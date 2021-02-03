package tn.esprit.spring.DAO.entity;

import java.io.Serializable;


import java.util.List;
import java.util.Objects;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table
public class Category implements Serializable {
//	private static final Logger L=Logger.getLogger(Category.class);
	
	@Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,unique=true)
	private int categoryId;
	
	@Column(length=45, nullable=false,unique=true)
	private String categoryName;

	@OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
	private List<Book> book;
	

	@JsonIgnore
	@ManyToMany(mappedBy="categories")
	private List<Event> events;
	
	
	public List<Event> getEvent() {
		return events;
	}


	public void setEvent(List<Event> events) {
		this.events = events;
	} 
	
	public Category() {
		
	}


	public Category(int categoryId, String categoryName) {
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}


	public Category(String categoryName) {
	
		this.categoryName = categoryName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) 
			return false;
		Category category = (Category) o;
		return categoryId == category.categoryId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId);
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}


	
}

