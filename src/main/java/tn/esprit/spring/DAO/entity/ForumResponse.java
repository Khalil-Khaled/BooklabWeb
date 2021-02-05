package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ForumResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String message;
	
	@Enumerated (EnumType.STRING)
	private Status status;
	

	@ManyToOne
	private Forum forum;
	
	@ManyToOne
	private User user;

	public ForumResponse() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 
}