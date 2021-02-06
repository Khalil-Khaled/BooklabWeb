package tn.esprit.spring.services;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.ForumResponse;
import tn.esprit.spring.DAO.entity.Status;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.IForumDAO;
import tn.esprit.spring.DAO.repository.IForumResponseDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;

@Service
public class ForumServicesImpl implements IForumServices {

	@Autowired
	IForumDAO iForumDAO;
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Autowired
	IForumResponseDAO iForumResponseDAO;
	
	
	@Override
	public Forum addForum(Forum forum) {
		return iForumDAO.save(forum);
	}
	
	@Override
	public void removeForum(int id) {
		iForumDAO.deleteById(id);
	}
	
	@Override
	public List<Forum> getAllForums() {
		return iForumDAO.findAll();
	}
	
	@Override
	public Forum getForum(int id) {
		return iForumDAO.findById(id).orElse(null);
	}
	
	@Override
	public List<Forum> getValidatedForums() {
		List<Forum> forums = iForumDAO.findByStatus(Status.Validated);
		for (Forum forum : forums) {
			List <ForumResponse> forumResponses = forum.getResponses();
			forumResponses = forumResponses.stream().filter(f->f.getStatus().equals(Status.Validated)).collect(Collectors.toList());
			forum.setResponses(forumResponses);
		}
		 return forums;
	}
	
	@Override
	public List<Forum> getWaitingForums() {
		return iForumDAO.findByStatus(Status.Waiting);
	}
	
	@Override
	public Forum updateForumUser (Forum forum) {
		Forum forumDB = iForumDAO.findById(forum.getId()).orElse(null);
		
		if (forum.getDescription()!= null) {
			forumDB.setDescription(forum.getDescription());
		}
		if (forum.getTitle()!=null) {
			forumDB.setTitle(forum.getTitle());
		}
		if (!forumDB.getStatus().equals(Status.Waiting)) {
			forumDB.setStatus(Status.Waiting);
		}
		
		return iForumDAO.save(forumDB);
	}
	
	@Override
	public void assignForumToUser (Forum forum) {
		User userDB = iUserRepository.findById(forum.getUser().getUserid());
		System.out.println(userDB);
		forum.setUser(userDB);
	}
	
	@Override
	public Forum updateForumStatusAdmin(Forum forum) {
		Forum forumDB = iForumDAO.findById(forum.getId()).orElse(null);
		if (forum.getStatus()!=null) {
			forumDB.setStatus(forum.getStatus());
		}
		return iForumDAO.save(forumDB);
	}
	
	@Override
	public ForumResponse addForumResponse(ForumResponse forumResponse) {
		return iForumResponseDAO.save(forumResponse);
	}
	
	@Override
	public void removeForumResponse(int id) {
		iForumResponseDAO.deleteById(id);
	}
	
	@Override
	public ForumResponse updateForumResponseUser(ForumResponse forumResponse) {
		ForumResponse forumResponseDB = iForumResponseDAO.findById(forumResponse.getId()).orElse(null);
		if (forumResponse.getMessage()!= null){
			forumResponseDB.setMessage(forumResponse.getMessage());
		}
		if (!forumResponseDB.getStatus().equals(Status.Waiting)) {
			forumResponseDB.setStatus(Status.Waiting);
		}
		return iForumResponseDAO.save(forumResponseDB);
	}
	
	@Override
	public ForumResponse updateForumResponseStatusAdmin(ForumResponse forumResponse) {
		ForumResponse forumResponseDB = iForumResponseDAO.findById(forumResponse.getId()).orElse(null);
		if (forumResponse.getStatus()!=null) {
			forumResponseDB.setStatus(forumResponse.getStatus());
		}
		return iForumResponseDAO.save(forumResponseDB);
	}
	
	@Override
	public void assignForumResponseToForum(ForumResponse forumResponse) {
		Forum forum = iForumDAO.findById(forumResponse.getForum().getId()).orElse(null);
		forumResponse.setForum(forum);
	}
	
	@Override
	public void assignForumResponseToUser(ForumResponse forumResponse) {
		User user = iUserRepository.findById(forumResponse.getUser().getUserid());
		forumResponse.setUser(user);
	}
	
	@Override
	public List<Forum> findForumsByUsername (String username){
		User user = iUserRepository.Auth(username);
		if (user != null)
			return user.getForums().stream().filter(f->f.getStatus().equals(Status.Validated)).collect(Collectors.toList());
		else 
			return getValidatedForums();
	}
	
	public List<Forum> getRecentForums () {
		return iForumDAO.getMostRecentForums();
	}

	@Override
	public List<User> findTopUsersWithMostDownVotesByMonth() {
		List<User> users = iForumDAO.findUsersWithMostDownVotesByMonth();
		users = users.stream().limit(10).collect(Collectors.toList());
		for (User user : users) {
			mailling(user.getEmail(), "Hello "+user.getFirstname()+", "
					+ "\n This is a warning concerning your recent behaviour on our forum platform."
					+ "\n We recommend that you verify your posts before sending them since we got many complaints."
					+ "\n Regards from Booklab team !! ");
		}
		return users;
	}
	
	public void mailling(String mail,String message) {
		final String username = "booklab.pro@gmail.com";
		final String password = "esprit123";
		String fromEmail = "booklab.pro@gmail.com";
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			msg.setSubject("Warning Regarding Your Recent Behaviour on Booklab");
			Multipart emailContent = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(message);
			emailContent.addBodyPart(textBodyPart);
			msg.setContent(emailContent);
			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
