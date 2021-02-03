package tn.esprit.spring.DAO.entity;

import java.io.Serializable;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="eventId")
	private int id ;
	
	
	private String name ;
	
	
	private String description ;
	
	@Temporal(TemporalType.DATE)
	
	private Date begin_date ;

	@Temporal(TemporalType.DATE)
	
	private Date end_date ;
	
	
	private String location ;
	
	/* MANY TO ONE BIDIRECTIONAL Event<*---1>User */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	private User user ;
	
	/* MANY TO MANY BIDIRECTIONAL Event<*---*>User */
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="participants",joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> users;
	
	/* MANY TO MANY BIDIRECTIONAL Event<*---*>User */
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="eventCategories",joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;

	public Event() {
		super();
	}

	public Event(String name, String description, Date begin_date, Date end_date, String location, User user,
			List<User> users, List<Category> categories) {
		super();
		this.name = name;
		this.description = description;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.location = location;
		this.user = user;
		this.users = users;
		this.categories = categories;
	}

	public List<User> getUsers() {
		return users;
	}

	public void ListUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void ListId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void ListName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void ListDescription(String description) {
		this.description = description;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void ListBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void ListEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getLocation() {
		return location;
	}

	public void ListLocation(String location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void ListUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", begin_date=" + begin_date
				+ ", end_date=" + end_date + ", location=" + location + ", user=" + user + ", users=" + users
				+ ", categories=" + categories + "]";
	}

}
