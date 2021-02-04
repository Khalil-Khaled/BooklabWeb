package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



@Entity

public class Item implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="Integer")
	private int itemId;
	
	 @Enumerated(EnumType.STRING)
	 private ItemType typeItem;
	
	@Column(nullable=false)
	private String itemName;
	@Column(nullable=false,columnDefinition="NUMBER(5,2)")
	private float price;
	@Column(nullable=false,columnDefinition="INTEGER")
	private int itemAgeRating;
	
	@Column(nullable=false)
	private String itemDescription;
	
	@Column(nullable=true)
	private String author;
	
	@Column(nullable=true,columnDefinition="INTEGER")
	private int pageNumber;
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date bookPublishDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private Category category;
	
	
	@ManyToMany(mappedBy="items")
    private Set<Offer> offers;
	
	public Item() {
		super();
	}

	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ItemType getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(ItemType typeItem) {
		this.typeItem = typeItem;
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

	public int getItemAgeRating() {
		return itemAgeRating;
	}

	public void setItemAgeRating(int itemAgeRating) {
		this.itemAgeRating = itemAgeRating;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Date getBookPublishDate() {
		return bookPublishDate;
	}

	public void setBookPublishDate(Date bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", typeItem=" + typeItem + ", itemName=" + itemName + ", price=" + price
				+ ", itemAgeRating=" + itemAgeRating + ", itemDescription=" + itemDescription + ", author=" + author
				+ ", pageNumber=" + pageNumber + ", bookPublishDate=" + bookPublishDate + ", category=" + category
				+ "]";
	}

	

 
	
	
	
}
