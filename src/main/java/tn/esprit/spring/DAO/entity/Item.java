package tn.esprit.spring.DAO.entity;


import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.sun.istack.NotNull;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table
//@Inheritance(strategy=InheritanceType.JOINED)
public class Item implements Serializable {

//	private static final Logger L=Logger.getLogger(Category.class);
	
	@Id
	 @SequenceGenerator(name = "seqGen", sequenceName = "seqGen", initialValue = 5, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,unique=true)
	private int itemId;
	
	@Column(length=45, nullable=false,unique=true)
	private String itemName;
	private float price;
	private String itemImage;
	
	@Enumerated(EnumType.STRING)
	private Role itemRole;
	

	
	
	public Item() {
		
	}

	public Item(int itemId, String itemName, float price, String itemImage) {
		
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.itemImage = itemImage;
	}
	
	

	public Item(String itemName, float price, String itemImage, Role itemRole) {
		
		this.itemName = itemName;
		this.price = price;
		this.itemImage = itemImage;
		this.itemRole = itemRole;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	
	public Role getItemRole() {
		return itemRole;
	}

	public void setItemRole(Role itemRole) {
		this.itemRole = itemRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (o == null || getClass() != o.getClass()) 
			return false;
		Item item = (Item) o;
		return itemId == item.itemId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}
	@Override
	public String toString() {
		return "ItemB [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", itemImage=" + itemImage
				+ "]";
	}
	
	
	
}
