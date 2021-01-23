package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.ComplaintResponse;
import tn.esprit.spring.services.ComplaintResponseService;


@RestController
public class ComplaintResponseController {
	 @Autowired
	 private ComplaintResponseService complaintResponseService;
	
	 @RequestMapping(method=RequestMethod.POST ,value="/admin/complaints/{complaintId}")
		public ComplaintResponse respondToComplaint(@RequestBody ComplaintResponse complaintResponse,@PathVariable int complaintId) {
			return complaintResponseService.respondToComplaint(complaintResponse,complaintId);

		}
		@RequestMapping("/admin/complaints/responses")
	    public List<ComplaintResponse> getComplaintsResponses() {
	        return complaintResponseService.showAllComplaintsResponses();
	    }
}
