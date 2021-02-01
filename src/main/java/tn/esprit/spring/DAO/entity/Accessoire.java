package tn.esprit.spring.DAO.entity;

import javax.persistence.Entity;



@Entity
public class Accessoire extends Item {

	
	private String accessoryDescription;
	
	private int ageRatingAccessory;
	
	
	public Accessoire() {
		
	}


	public Accessoire(int itemId, String itemName, float price, String itemImage, String accessoryName,
			String accessoryDescription, String accessoryImage, int ageRatingAccessory) {
		super(itemId, itemName, price, itemImage);

		this.accessoryDescription = accessoryDescription;
	
		this.ageRatingAccessory = ageRatingAccessory;
	}


	


	public String getAccessoryDescription() {
		return accessoryDescription;
	}


	public void setAccessoryDescription(String accessoryDescription) {
		this.accessoryDescription = accessoryDescription;
	}



	public int getAgeRatingAccessory() {
		return ageRatingAccessory;
	}


	public void setAgeRatingAccessory(int ageRatingAccessory) {
		this.ageRatingAccessory = ageRatingAccessory;
	}


	@Override
	public String toString() {
		return "Accessoire [" + " accessoryDescription=" + accessoryDescription
				+" ageRatingAccessory=" + ageRatingAccessory + "]";
	}
	
	
	
}
