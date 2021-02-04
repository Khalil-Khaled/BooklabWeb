package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.ForumResponse;
import tn.esprit.spring.DAO.entity.User;

public interface IForumServices {
	public Forum addForum (Forum forum);
	public void removeForum (int id);
	public List<Forum> getAllForums ();
	public List<Forum> getValidatedForums();
	public Forum updateForumUser (Forum forum);
	public Forum updateForumStatusAdmin (Forum forum);
	public void assignForumToUser (Forum forum, User user);
	public ForumResponse addForumResponse (ForumResponse forumResponse);
	public void removeForumResponse (ForumResponse forumResponse);
	public ForumResponse updateForumResponseUser (ForumResponse forumResponse);
	public ForumResponse updateForumResponseStatusAdmin (ForumResponse forumResponse);
	public void assignForumResponseToForum (ForumResponse forumResponse, Forum forum);
	public void assignForumResponseToUser(ForumResponse forumResponse, User user);
	
}
