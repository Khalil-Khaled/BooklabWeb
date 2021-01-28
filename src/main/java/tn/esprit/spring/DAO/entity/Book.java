package tn.esprit.spring.DAO.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book extends ItemB {

	private String bookDescription;
	
	private String author;
	private int pageNumber;
	private int ageRatingBook; 
	
	@Temporal(TemporalType.DATE)
	private Date bookPublishDate;
	
	
	
	/*@OneToMany
	private List<Category> category;*/
	public Book() {
		super();
	}

	public Book(int itemId, String itemName, float price, String itemImage, String bookDescription, String author,
			int pageNumber, int ageRatingBook, Date bookPublishDate) {
		super(itemId, itemName, price, itemImage);
		this.bookDescription = bookDescription;
		this.author = author;
		this.pageNumber = pageNumber;
		this.ageRatingBook = ageRatingBook;
		this.bookPublishDate = bookPublishDate;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
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

	public int getAgeRatingBook() {
		return ageRatingBook;
	}

	public void setAgeRatingBook(int ageRatingBook) {
		this.ageRatingBook = ageRatingBook;
	}

	public Date getBookPublishDate() {
		return bookPublishDate;
	}

	public void setBookPublishDate(Date bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}

	@Override
	public String toString() {
		return "Book [bookDescription=" + bookDescription + ", author=" + author + ", pageNumber=" + pageNumber
				+ ", ageRatingBook=" + ageRatingBook + ", bookPublishDate=" + bookPublishDate + "]";
	}
/*
	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	
	*/
	
}
