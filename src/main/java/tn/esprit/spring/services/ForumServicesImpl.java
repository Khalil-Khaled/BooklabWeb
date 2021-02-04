package tn.esprit.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Customer;
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
	public void assignForumToUser (Forum forum, User user) {
		User userDB = iUserRepository.findById(user.getUserid());
		forum.setUser(userDB);
		iForumDAO.save(forum);
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
	public void removeForumResponse(ForumResponse forumResponse) {
		iForumResponseDAO.deleteById(forumResponse.getId());
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
	public void assignForumResponseToForum(ForumResponse forumResponse, Forum forum) {
		forumResponse.setForum(forum);
		iForumResponseDAO.save(forumResponse);
	}
	
	@Override
	public void assignForumResponseToUser(ForumResponse forumResponse, User user) {
		forumResponse.setUser(user);
		iForumResponseDAO.save(forumResponse);
	}

	
	

}
