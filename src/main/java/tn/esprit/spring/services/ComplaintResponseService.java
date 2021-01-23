package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.ComplaintResponse;
import tn.esprit.spring.DAO.entity.ComplaintStatus;
import tn.esprit.spring.DAO.repository.IComplaintDAO;
import tn.esprit.spring.DAO.repository.IComplaintResponseDAO;

@Service
public class ComplaintResponseService implements IComplaintResponseService{
	@Autowired
	private IComplaintResponseDAO complaintResponseRepository;
	@Autowired
	private IComplaintDAO compaintRepository;
	

	@Override
	public List<Complaint> showAllComplaints() {
		List<Complaint> allComplaints= new ArrayList<>();
		compaintRepository.findAll().forEach(allComplaints::add);
		  return allComplaints;
	}
	@Override
	public Complaint showComplaint(int complaintId) {
		return compaintRepository.findById(complaintId).get();
	}
	@Override
	public List<ComplaintResponse> showAllComplaintsResponses() {
		List<ComplaintResponse> allComplaintsResponses= new ArrayList<>();
		complaintResponseRepository.findAll().forEach(allComplaintsResponses::add);
		  return allComplaintsResponses;
	}

	@Override
	public void deleteComplaintResponse(ComplaintResponse c) {
		if(showAllComplaintsResponses().contains(c))
			complaintResponseRepository.delete(c);
	}

	

	@Override
	public ComplaintResponse respondToComplaint(ComplaintResponse complaintResponse,int complaintId) {
		Complaint complaint =compaintRepository.findById(complaintId).get();
		 complaintResponse.setComplaint(complaint);
		 complaint.setComplaintResponse(complaintResponse);
 		complaint.setComplaintStatus(ComplaintStatus.COMPLETED);
		return complaintResponseRepository.save(complaintResponse);
	}
	@Override
	public ComplaintResponse showComplaintResponse(int id) {
		return complaintResponseRepository.findById(id).get();
	}

	@Override
	public void updateComplaintResponse(int id, ComplaintResponse c) {
		if(complaintResponseRepository.existsById(id))
			complaintResponseRepository.save(c);

	}

}
