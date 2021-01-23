package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int userid;
	
	
    private String userName;
    private String firstName;
    private String profileImage;
    private String lastName;
    private String email;
    private String password;
    private String questionVerif;
    private String answerVerif;
    private String stripeID;
    
    private int rate;
    
    
    @OneToMany (mappedBy="customer", cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("customer")
    private List<Offer> offer;

	@OneToMany (mappedBy="customer")
	@JsonIgnoreProperties("customer")
    private List<Forum> forums;
    
	@OneToMany (mappedBy="customer")
	@JsonIgnoreProperties("customer")
	private List<ForumResponse> forumResponses;
	
    public Customer(){
    	
    }


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getQuestionVerif() {
		return questionVerif;
	}

	public void setQuestionVerif(String questionVerif) {
		this.questionVerif = questionVerif;
	}

	public String getAnswerVerif() {
		return answerVerif;
	}

	public void setAnswerVerif(String answerVerif) {
		this.answerVerif = answerVerif;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	

	public String getStripeID() {
		return stripeID;
	}

	public void setStripeID(String stripeID) {
		this.stripeID = stripeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userid;
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
		Customer other = (Customer) obj;
		if (userid != other.userid)
			return false;
		return true;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

    public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", userName=" + userName + ", firstName=" + firstName + ", profileImage="
				+ profileImage + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", questionVerif=" + questionVerif + ", answerVerif=" + answerVerif + ", stripeID=" + stripeID
				+ ", rate=" + rate + ", offer=" + offer + ", forums=" + forums + "]";
	}

    
    
}
