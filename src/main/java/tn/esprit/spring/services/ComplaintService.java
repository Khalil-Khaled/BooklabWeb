package tn.esprit.spring.services;

import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.ComplaintStatus;
import tn.esprit.spring.DAO.entity.Customer;
import tn.esprit.spring.DAO.repository.IComplaintDAO;
import tn.esprit.spring.DAO.repository.ICustomerDAO;


@Service
public class ComplaintService implements IComplaintService {
	@Autowired
	private IComplaintDAO complaintRepository;
	 @Autowired 
	 private ICustomerDAO customerRepository;

	@Override
	  public List<Complaint> showComplaintsByCustomer(int userId) {
		List<Complaint> complaintsByCustomer= new ArrayList<>();
		  complaintRepository.findByCustomerUserid(userId).forEach(complaintsByCustomer::add);
		  return complaintsByCustomer;
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
			Customer user = customerRepository.findById(userid).get();
			c.setCustomer(user);
			c.setComplaintStatus(ComplaintStatus.NEW);
			return complaintRepository.save(c);
	}

	@Override
	public void updateComplaint( Complaint c,int userid) {
		Customer user = customerRepository.findById(userid).get();
		c.setCustomer(user);
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
	
}
