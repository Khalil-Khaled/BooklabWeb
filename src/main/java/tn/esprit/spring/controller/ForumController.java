package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.ForumResponse;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.services.IForumServices;
import tn.esprit.spring.services.IUserservices;

@RestController
public class ForumController {
	
	@Autowired
	IForumServices iForumServices;
	
	@Autowired
	IUserservices iUserServices;
	
	
	@PostMapping("/forums/add")
	public Forum addForum (@RequestBody Forum forum) {
		System.out.println(forum);
		iForumServices.assignForumToUser(forum);
		return iForumServices.addForum(forum);
	}
	
	@DeleteMapping ("/admin/forums/remove/{id}")
	public void removeForum(@PathVariable int id) {
		iForumServices.removeForum(id);
	}
	
	@GetMapping ("/admin/forums")
	public List<Forum> getAllForums() {
		return iForumServices.getAllForums();
	}
	
	@GetMapping ("/forums/")
	public List<Forum> getValidatedForums() {
		return iForumServices.getValidatedForums();
	}
	
	@GetMapping ("/admin/forums/waiting")
	public List<Forum> getWaitingForums() {
		return iForumServices.getWaitingForums();
	}
	
	@GetMapping ("/forums/recent")
	public List<Forum> getRecentForums () {
		return iForumServices.getRecentForums();
	}
	
	@GetMapping ("/admin/forums/{id}")
	public Forum getForum(@PathVariable int id) {
		return iForumServices.getForum(id);
	}
	
	@PostMapping("/forums/update")
	public Forum updateForumUser (@RequestBody Forum forum) {
		return iForumServices.updateForumUser(forum);
	}
	
	@PostMapping ("/admin/forums/update")
	public Forum updateForumStatusAdmin(@RequestBody Forum forum) {
		return iForumServices.updateForumStatusAdmin(forum);
	}
	
	@PostMapping ("/forum/forumResponse/add")
	public ForumResponse addForumResponse(@RequestBody ForumResponse forumResponse) {
		iForumServices.assignForumResponseToForum(forumResponse);
		iForumServices.assignForumResponseToUser(forumResponse);
		return iForumServices.addForumResponse(forumResponse);
	}
	
	@DeleteMapping ("/forum/forumResponse/delete/{id}")
	public void removeForumResponse(@PathVariable int id) {
		iForumServices.removeForumResponse(id);
	}
	
	@PostMapping ("/forum/forumResponse/update")
	public ForumResponse updateForumResponseUser(@RequestBody ForumResponse forumResponse) {
		return iForumServices.updateForumResponseUser(forumResponse);
	}
	
	@PostMapping ("/admin/forum/forumResponse/update")
	public ForumResponse updateForumResponseStatusAdmin(@RequestBody ForumResponse forumResponse) {
		return iForumServices.updateForumResponseStatusAdmin(forumResponse);
	}
	
	@GetMapping ("/forums/search")
	public List<Forum> findForumsByUsername (@Param("username") String username) {
		return iForumServices.findForumsByUsername(username);
	}
	
	@GetMapping ("/forums/badUsers")
	public List<User> findTopUsersWithMostDownVotesByMonth() {
		return iForumServices.findTopUsersWithMostDownVotesByMonth();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
