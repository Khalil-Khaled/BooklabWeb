package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.ComplaintResponse;
 

public interface IComplaintResponseService {
	public List<Complaint> showAllComplaints();
	public List<ComplaintResponse> showAllComplaintsResponses();
	public void deleteComplaintResponse(ComplaintResponse c);
	public ComplaintResponse showComplaintResponse(int id);
	public void updateComplaintResponse(int id, ComplaintResponse c);
	public Complaint showComplaint(int complaintId);
	public ComplaintResponse respondToComplaint(ComplaintResponse complaintResponse,int complaintId);
}
