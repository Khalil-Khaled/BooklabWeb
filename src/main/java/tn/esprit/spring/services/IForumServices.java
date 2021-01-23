package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Customer;
import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.ForumResponse;

public interface IForumServices {
	public Forum addForum (Forum forum);
	public void removeForum (int id);
	public List<Forum> getAllForums ();
	public List<Forum> getValidatedForums();
	public Forum updateForumClient (Forum forum);
	public Forum updateForumStatusAdmin (Forum forum);
	public void assignForumToCustomer (Forum forum, Customer customer);
	public ForumResponse addForumResponse (ForumResponse forumResponse);
	public void removeForumResponse (ForumResponse forumResponse);
	public ForumResponse updateForumResponseClient (ForumResponse forumResponse);
	public ForumResponse updateForumResponseStatusAdmin (ForumResponse forumResponse);
	public void assignForumResponseToForum (ForumResponse forumResponse, Forum forum);
	public void assignForumResponseToCustomer(ForumResponse forumResponse, Customer customer);
	
}
