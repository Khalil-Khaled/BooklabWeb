package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Offer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idOffer;
	
	@Enumerated(EnumType.STRING)
    private Type typeOffer;
    
	
    private float priceOffer;
    private String descriptionOffer;
    
    @Enumerated(EnumType.STRING)
    private Status offerStatus;
    
    private String stripeId;
    
    @ManyToOne(cascade= CascadeType.ALL)
    private Customer customer;

	
	public Offer () {
		
	}

	public int getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}

	public Type getTypeOffer() {
		return typeOffer;
	}

	public void setTypeOffer(Type typeOffer) {
		this.typeOffer = typeOffer;
	}

	public float getPriceOffer() {
		return priceOffer;
	}

	public void setPriceOffer(float priceOffer) {
		this.priceOffer = priceOffer;
	}

	public String getDescriptionOffer() {
		return descriptionOffer;
	}

	public void setDescriptionOffer(String descriptionOffer) {
		this.descriptionOffer = descriptionOffer;
	}

	public Status getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(Status offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getStripeId() {
		return stripeId;
	}

	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOffer;
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
		Offer other = (Offer) obj;
		if (idOffer != other.idOffer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [idOffer=" + idOffer + ", typeOffer=" + typeOffer + ", priceOffer=" + priceOffer
				+ ", descriptionOffer=" + descriptionOffer + ", offerStatus=" + offerStatus + ", stripeId=" + stripeId
				+ "]";
	}
    
    
}
