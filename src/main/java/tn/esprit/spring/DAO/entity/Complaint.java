package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;



@Entity
@Table(name="Complaint")
public class Complaint implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="complaintId")
private int complaintId;

@NotNull
private String topic;

private String message ;

@NotNull
@Enumerated(EnumType.STRING)
private ComplaintType complaintType;

@NotNull
@Enumerated(EnumType.STRING)
private ComplaintStatus complaintStatus;

/* MANY TO ONE  Complaint<*---1>User */
@JsonIgnore
@ManyToOne
@JoinColumn(name="userid")
private User user ;

/* MANY TO ONE  Complaint<*---1>Event */
//@JsonIgnore
@ManyToOne
@JoinColumn(name="eventId")
private Event event ;

/* MANY TO ONE  Complaint<*---1>Order */
//@JsonIgnore
@ManyToOne
@JoinColumn(name="orderId")
private Orders order ;

/* MANY TO ONE  Complaint<*---1>Offer */
//@JsonIgnore
@ManyToOne
@JoinColumn(name="offerId")
private Offer offer ;

/*ONE TO ONE  Compalaint<1----1> ComplaintResponse */
@OneToOne
private ComplaintResponse complaintResponse;

public Orders getOrder() {
	return order;
}



public void setOrder(Orders order) {
	this.order = order;
}



public Offer getOffer() {
	return offer;
}



public void setOffer(Offer offer) {
	this.offer = offer;
}



public Complaint() {
		super();
	}



public Complaint(int complaintId, String topic, String message, ComplaintType complaintType, ComplaintStatus complaintStatus) {
	super();
	this.complaintId = complaintId;
	this.topic = topic;
	this.message = message;
	this.complaintType = complaintType;
	this.complaintStatus = complaintStatus;
}



public Complaint(int complaintId, String topic, String message, ComplaintType complaintType, ComplaintStatus complaintStatus,
		User user, ComplaintResponse complaintResponse) {
	super();
	this.complaintId = complaintId;
	this.topic = topic;
	this.message = message;
	this.complaintType = complaintType;
	this.complaintStatus = complaintStatus;
	this.user = user;
	this.complaintResponse = complaintResponse;
}



public int getId() {
	return complaintId;
}

public void setId(int complaintId) {
	this.complaintId = complaintId;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}



public ComplaintType getComplaintType() {
	return complaintType;
}



public void setComplaintType(ComplaintType complaintType) {
	this.complaintType = complaintType;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}



public ComplaintStatus getComplaintStatus() {
	return complaintStatus;
}

public void setComplaintStatus(ComplaintStatus complaintStatus) {
	this.complaintStatus = complaintStatus;
}




public int getComplaintId() {
	return complaintId;
}



public void setComplaintId(int complaintId) {
	this.complaintId = complaintId;
}



public User getUser() {
	return user;
}



public void setUser(User user) {
	this.user = user;
}


public ComplaintResponse getComplaintResponse() {
	return complaintResponse;
}



public Event getEvent() {
	return event;
}



public void setEvent(Event event) {
	this.event = event;
}



public void setComplaintResponse(ComplaintResponse complaintResponse) {
	this.complaintResponse = complaintResponse;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + complaintId;
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
	Complaint other = (Complaint) obj;
	if (complaintId != other.complaintId)
		return false;
	return true;
}



@Override
public String toString() {
	return "Complaint [complaintId=" + complaintId + ", topic=" + topic + ", message=" + message + ", type=" + complaintType
			+ ", complaintStatus=" + complaintStatus + ", user=" + user + ", complaintResponse="
			+ complaintResponse + "]";
}


}
