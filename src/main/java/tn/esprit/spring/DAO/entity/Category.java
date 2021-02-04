package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity

public class Category implements Serializable{
	@Id
    //@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, columnDefinition="INTEGER")
	private int categoryId;
	
	
	@Column(length=45,nullable=false, columnDefinition="TEXT")
	private String categoryName;


	public Category() {
		super();
	}


	public Category(String categoryName) {
		
		this.categoryName = categoryName;
	}


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
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
