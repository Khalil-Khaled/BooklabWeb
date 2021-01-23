package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
 


@Entity
@Table(name="ComplaintResponse")
public class ComplaintResponse implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="complaintResponseId")
private int complaintResponseId;
@NotNull
private String response;

@OneToOne(mappedBy="complaintResponse")
private Complaint complaint;


public ComplaintResponse() {
		super();
	}



public ComplaintResponse(int complaintResponseId, String response, Complaint complaint) {
	super();
	this.complaintResponseId = complaintResponseId;
	this.response = response;
	this.complaint = complaint;
}



public int getComplaintResponseId() {
	return complaintResponseId;
}

public void setComplaintResponseId(int complaintResponseId) {
	this.complaintResponseId = complaintResponseId;
}

public String getResponse() {
	return response;
}

public void setResponse(String response) {
	this.response = response;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
@JsonIgnore
public Complaint getComplaint() {
	return complaint;
}



public void setComplaint(Complaint complaint) {
	this.complaint = complaint;
}



@Override
public String toString() {
	return "ComplaintResponse [complaintResponseId=" + complaintResponseId + ", response=" + response + "]";
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((complaint == null) ? 0 : complaint.hashCode());
	result = prime * result + complaintResponseId;
	result = prime * result + ((response == null) ? 0 : response.hashCode());
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
	ComplaintResponse other = (ComplaintResponse) obj;
	if (complaint == null) {
		if (other.complaint != null)
			return false;
	} else if (!complaint.equals(other.complaint))
		return false;
	if (complaintResponseId != other.complaintResponseId)
		return false;
	if (response == null) {
		if (other.response != null)
			return false;
	} else if (!response.equals(other.response))
		return false;
	return true;
}



}
