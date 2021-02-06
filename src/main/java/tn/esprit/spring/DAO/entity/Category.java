package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Category implements Serializable{
	@Id
    //@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, columnDefinition="INTEGER")
	private int categoryId;
	
	
	@Column(length=45,nullable=false, columnDefinition="TEXT")
	private String categoryName;

	@OneToMany(mappedBy="category")
	private List<Item> item;
	
	@JsonIgnore
    @ManyToMany(mappedBy="categories")
    private List<Event> events;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
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
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", item=" + item + ", events="
				+ events + ", user=" + user + "]";
	}


	public List<Item> getItem() {
		return item;
	}


	public void setItem(List<Item> item) {
		this.item = item;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
