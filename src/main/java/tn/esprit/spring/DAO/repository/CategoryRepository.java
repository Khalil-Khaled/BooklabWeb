package tn.esprit.spring.DAO.repository;


import java.awt.print.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.DAO.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


//	public List<Book> findById (Book book);
	
	//@Query("SELECT o FROM Book b WHERE b.Name")
	
	@Query("SELECT c.categoryName from Category c")
	public List<String> names();
}
