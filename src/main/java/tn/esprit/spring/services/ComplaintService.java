package tn.esprit.spring.services;

import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.ComplaintStatus;
import tn.esprit.spring.DAO.entity.ComplaintType;
import tn.esprit.spring.DAO.entity.Event;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Orders;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.EventRepository;
import tn.esprit.spring.DAO.repository.IComplaintDAO;
import tn.esprit.spring.DAO.repository.IOfferDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;
import tn.esprit.spring.DAO.repository.OrdersRepo;


@Service
public class ComplaintService implements IComplaintService {
	@Autowired
	private IComplaintDAO complaintRepository;
	 @Autowired 
	 private IUserRepository userRepository;
	 @Autowired
	 private OfferServicesImpl offerService;
	 @Autowired
	 private OrdersRepo orderRepository;
	 @Autowired
	 private EventServices eventService;
	 
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
	public List<Complaint> showComplaintsByEvent(int userid,int eventId) {
		List<Complaint> complaintsByEvent= new ArrayList<>();
		complaintRepository.findByUserIdAndEventId(userid,eventId).forEach(complaintsByEvent::add);
		return complaintsByEvent;
	}
	@Override
	public List<Complaint> showComplaintsByOrder(int userid,int orderId) {
		List<Complaint> complaintsByOrder= new ArrayList<>();
		complaintRepository.findByUserIdAndOrderId(userid,orderId).forEach(complaintsByOrder::add);
		return complaintsByOrder;
	}
	@Override
	public List<Complaint> showComplaintsByOffer(int userid,int offerId) {
		List<Complaint> complaintsByOffer= new ArrayList<>();
		complaintRepository.findByUserIdAndOfferId(userid,offerId).forEach(complaintsByOffer::add);
		return complaintsByOffer;
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
	
	public Complaint addEventComplaint(Complaint complaint , int userid,int eventId) {
		User user =userRepository.findById(userid);
		complaint.setUser(user);
		complaint.setComplaintStatus(ComplaintStatus.NEW);
		complaint.setComplaintType(ComplaintType.EVENT);
		Event event=eventService.getEventById(eventId);
		complaint.setEvent(event);
		return complaintRepository.save(complaint);
	}
	
	@Override
	public Complaint addOrderComplaint(Complaint complaint, int userid, int orderId) {
		User user =userRepository.findById(userid);
		complaint.setUser(user);
		complaint.setComplaintStatus(ComplaintStatus.NEW);
		complaint.setComplaintType(ComplaintType.ORDER);
		Orders order=orderRepository.findById(orderId).get();
		complaint.setOrder(order);
		return complaintRepository.save(complaint);
	}
	@Override
	public Complaint addOfferComplaint(Complaint complaint, int userid, int offerId) {
		User user =userRepository.findById(userid);
		complaint.setUser(user);
		complaint.setComplaintStatus(ComplaintStatus.NEW);
		complaint.setComplaintType(ComplaintType.OFFER);
		Offer offer=offerService.getOffer(offerId);
		complaint.setOffer(offer);
		return complaintRepository.save(complaint);
	}
	
}
