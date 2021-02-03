package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.DAO.entity.*;

@Entity
@Table(name ="User")
public class User implements Serializable{



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String username;

private String firstname;

private String lastname;

@Enumerated(EnumType.STRING)
Role role; 
private String email;

private String password;

private String questionverif;

private String answerverif;

private String profilimage;

private int rate;

private String address;

private int telephone;

private int zipCode;


@JsonIgnore
@ManyToMany
private List<Event> events;

@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private List<Event> userEvents;

@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
private List<Complaint> userComplaints;


public User(int id, String username, String firstname, String lastname, Role role, String email, String password,
		String questionverif, String answerverif, String profilimage, int rate, String address, int telephone,
		int zipCode) {
	super();
	this.id = id;
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.role = role;
	this.email = email;
	this.password = password;
	this.questionverif = questionverif;
	this.answerverif = answerverif;
	this.profilimage = profilimage;
	this.rate = rate;
	this.address = address;
	this.telephone = telephone;
	this.zipCode = zipCode;
}


public User() {
	super();
}


public int getUserid() {
	return id;
}

public void setUserid(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getQuestionverif() {
	return questionverif;
}

public void setQuestionverif(String questionverif) {
	this.questionverif = questionverif;
}

public String getAnswerverif() {
	return answerverif;
}

public void setAnswerverif(String answerverif) {
	this.answerverif = answerverif;
}

public String getProfilimage() {
	return profilimage;
}

public void setProfilimage(String profilimage) {
	this.profilimage = profilimage;
}

public int getRate() {
	return rate;
}

public void setRate(int rate) {
	this.rate = rate;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getTelephone() {
	return telephone;
}

public void setTelephone(int telephone) {
	this.telephone = telephone;
}

public int getZipCode() {
	return zipCode;
}

public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}


public List<Event> getEvents() {
	return events;
}


public void setEvents(List<Event> events) {
	this.events = events;
}


public List<Event> getUserEvents() {
	return userEvents;
}


public void setUserEvents(List<Event> userEvents) {
	this.userEvents = userEvents;
}


@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", role=" + role + ", email=" + email + ", password=" + password + ", questionverif=" + questionverif
			+ ", answerverif=" + answerverif + ", profilimage=" + profilimage + ", rate=" + rate + ", address="
			+ address + ", telephone=" + telephone + ", zipCode=" + zipCode + "]";
}



}
