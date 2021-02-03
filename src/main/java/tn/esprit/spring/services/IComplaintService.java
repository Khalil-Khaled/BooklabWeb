package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Complaint;

  
public interface IComplaintService {

	public void deleteComplaint(Complaint c);
	public Complaint addComplaint(Complaint c, int userid);
	public  List<Complaint> showComplaintsByUser(int userid);
	public Complaint showComplaint(int id);
	public void updateComplaint(Complaint c,int userid);
	public List<Complaint> showAllComplaints() ;
	public void deleteComplaint(int id);
	public void saveComplaintResponseByComplaintId(int id);
	public int countComplaintsPerUser(int userid);
}
