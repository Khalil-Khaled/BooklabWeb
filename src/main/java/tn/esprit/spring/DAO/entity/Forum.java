package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Forum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	
	@Enumerated (EnumType.STRING)
	private Status status;
	
	@OneToMany (mappedBy = "forum", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("forum")
	private List<ForumResponse> responses;
	
	
	@ManyToOne
	private User user;

	public Forum() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ForumResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ForumResponse> responses) {
		this.responses = responses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
