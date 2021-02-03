package tn.esprit.spring.services;

import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.ComplaintStatus;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.IComplaintDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;


@Service
public class ComplaintService implements IComplaintService {
	@Autowired
	private IComplaintDAO complaintRepository;
	 @Autowired 
	 private IUserRepository userRepository;

	@Override
	  public List<Complaint> showComplaintsByUser(int userid) {
		List<Complaint> complaintsByUser= new ArrayList<>();
		  complaintRepository.findByUserId(userid).forEach(complaintsByUser::add);
		  return complaintsByUser;
	  }
	@Override
	  public List<Complaint> showAllComplaints() {
		List<Complaint> allComplaints= new ArrayList<>();
		  complaintRepository.findAll().forEach(allComplaints::add);
		  return allComplaints;
	  }

	
	@Override
	public Complaint showComplaint(int id) {
		return complaintRepository.findById(id).get();
	}
	@Override
	public void deleteComplaint(Complaint c) {
		if(showAllComplaints().contains(c))
			complaintRepository.delete(c);
	}

	@Override
	public Complaint addComplaint(Complaint c, int userid) {
			User user =userRepository.findById(userid);
			c.setUser(user);
			c.setComplaintStatus(ComplaintStatus.NEW);
			return complaintRepository.save(c);
	}

	@Override
	public void updateComplaint( Complaint c,int userid) {
		User user =userRepository.findById(userid);
		c.setUser(user);
		c.setComplaintStatus(ComplaintStatus.NEW);
		  complaintRepository.save(c);
	}
	@Override
	public void deleteComplaint(int id) {
		complaintRepository.deleteById(id);
	}
	@Override
	public void saveComplaintResponseByComplaintId(int id) {
		complaintRepository.save(complaintRepository.findById(id).get());
	}
	@Override
	public int countComplaintsPerUser(int userid) {
		return complaintRepository.countComplaintsByUser(userid);
	}
	
}
