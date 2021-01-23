package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.services.ComplaintService;
 
@RestController
public class ComplaintController {
	 @Autowired
	  private  ComplaintService complaintService;
	/*C U S T O M E R*/
	  	@RequestMapping(method=RequestMethod.POST ,value="/customer/{userid}/complaints")
		public Complaint addComplaint(@RequestBody Complaint complaint,@PathVariable int userid) {
//			complaint.setCustomer(new Customer(userId,""));
//			complaint.setComplaintStatus(ComplaintStatus.NEW);  				
			return  complaintService.addComplaint(complaint, userid);
		}
	  
	  	@RequestMapping("/customer/{userid}/complaints")
	    public List<Complaint> getComplaintsByCustomer(@PathVariable int userid) {
	        return complaintService.showComplaintsByCustomer(userid);
	    }
	  	
		@RequestMapping("/customer/{userid}/complaints/{complaintId}")
	  	public Complaint getComplaintByCustomer(@PathVariable int userid,@PathVariable int complaintId) {
	     return complaintService.showComplaint(complaintId);
		}
		@RequestMapping(method=RequestMethod.PUT , value="/customer/{userid}/complaints/{complaintId}")
		public void updateComplaint(@RequestBody Complaint complaint , @PathVariable int userid , @PathVariable int complaintId) {
			complaintService.updateComplaint(complaint,userid);
		}
		@RequestMapping(method=RequestMethod.DELETE , value="/customer/{userId}/complaints/{complaintId}")
		public void deleteComplaint(@PathVariable int userId , @PathVariable int complaintId) {
			complaintService.deleteComplaint(complaintId);
		}
	///*A D M I N*/
	 	@RequestMapping("/admin/complaints")
	    public List<Complaint> getAllComplaints() {
	        return complaintService.showAllComplaints();
	    }

	  	@RequestMapping("/admin/complaints/{complaintId}")
	  	public Complaint getComplaint(@PathVariable int complaintId) {
	     return complaintService.showComplaint(complaintId);
	  }
	  	

}