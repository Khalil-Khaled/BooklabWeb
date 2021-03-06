package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.entity.Verification_Code;
import tn.esprit.spring.DAO.repository.IUserRepository;
import tn.esprit.spring.DAO.repository.VerificationCodeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserServices implements IUserservices{
	@Autowired
	private IUserRepository userRepository;
	VerificationCodeRepository vcRepo;
	Verification_Code Vc=new Verification_Code();
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	public static int  coderest=0;
	public static int  idverif=0;
	private static final Logger L=LogManager.getLogger(UserServices.class);
	//add user
	public User addCustomer(User u){
	return userRepository.save(u);
}
	//get all user *********************************
	  public List<User> showAllCustomer() {
		List<User> allComplaints= new ArrayList<>();
		userRepository.findAll().forEach(allComplaints::add);
		  return allComplaints;
	  }
	  //get all admin**********************************
	  public List<User> showAlladmin() {
		return (List<User>)userRepository.adminlist();
		  }
		//get user by id***************************************
		public User GetUser(int id) {
			return userRepository.findById(id);
		}
		//delete user ************************************ 
		public void Delete(int id) {
			User x=userRepository.findById(id);
			if(x!=null) {
				userRepository.deleteById(id);
			}
		}
		
		public String Signup(User us) {
			L.info(us);
			if(userRepository.Existmail(us.getEmail(),us.getUsername())==false) {
				System.out.println(us.getPassword());
				String encodedPassword1 = bCryptPasswordEncoder.encode("123");
				System.out.println(encodedPassword1);
				String encodedPassword = bCryptPasswordEncoder.encode(us.getPassword());
				String verifCode = bCryptPasswordEncoder.encode(us.getFirstname());
				us.setPassword(encodedPassword);
				User x=userRepository.save(us);

				mailling(us.getEmail(),"Your verification code is : "+verifCode );
				return "User added successfully !";
			}
			return "User already Exist";
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
				msg.setSubject("User Verification");
				Multipart emailContent = new MimeMultipart();
				MimeBodyPart textBodyPart = new MimeBodyPart();
				textBodyPart.setText(message);
				emailContent.addBodyPart(textBodyPart);
				msg.setContent(emailContent);
				Transport.send(msg);
				System.out.println("Sent message");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
		public User Update(User us) {
			if(userRepository.findById(us.getUserid())!=null) {
				String encodedPassword = bCryptPasswordEncoder.encode(us.getPassword());
				// TODO Auto-generated method stub
				us.setPassword(encodedPassword);
				userRepository.save(us);
				return us;
			}
			return null;
		}
		public User Authority(String username, String password)  {
			User logged= userRepository.Auth(username);
			  System.out.println(logged);
			if(bCryptPasswordEncoder.matches(password,logged.getPassword())){
				return logged;
			}

			return null;
		}
		
		public String UpdateRestPassword(int code, String password, int id) {
			// TODO Auto-generated method stub
			User t=userRepository.findById(id);
			System.out.println(t);
			if(t==null) {
				return "User not found";
			}
			if(UserServices.coderest==code) {
				t.setPassword(bCryptPasswordEncoder.encode(password));
				userRepository.save(t);
				return "Password updated successfully !";
			}

			return "wrong code";
		}
		public void AddCode(String code, User user_id) {
			// TODO Auto-generated method stub
			Vc.setCode(code);
			Vc.setUser_id(user_id);
			vcRepo.save(Vc);
		}
		public boolean isVerified(String login, String pwd) {
			if(userRepository.isverified(login)==null)
				return false;
			return true;
		}
		public String VerifyMyaccount(User u, String verifcode) {
			// TODO Auto-generated method stub
			if(isVerified(u.getUsername(),u.getPassword()))
				return "you are already verified";

			else if(bCryptPasswordEncoder.matches(userRepository.Auth(u.getUsername()).getFirstname(),verifcode) && (userRepository.Auth(u.getUsername())!=null )) {
				AddCode(verifcode, userRepository.Auth(u.getUsername()));
				return "you have been verified";
			}
			return "Something went wrong";
		}
		public void ifNotverifiedVerif(int id,String verification_code) {
			// TODO Auto-generated method stub
			if(vcRepo.CheckVerification(verification_code,id)==null) {
				AddCode(verification_code,userRepository.findById(id) );
			}
		}
}
