package tn.esprit.spring.DAO.repository;




import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Complaint;
import tn.esprit.spring.DAO.entity.Event;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	
	@Query("SELECT * FROM Category c  WHERE c.categoryName= :categoryName order by c.categoryName")
	public Category findByName(@Param("categoryName") String categoryName);
	
	
	@Query("SELECT * FROM Category c, Item i WHERE i.itemType = 'BOOK' and c.categoryId = :categoryId")
	public Category findById(@Param("categoryId") int categoryId);
	
	
	//public List<Category> finById(int itemId);
	//@Query("SELECT COUNT(*) FROM Category c Join c.Item i WHERE i.itemtype ='BOOK'")
	@Query("SELECT COUNT(i) FROM Category c JOIN c.item i WHERE c.categoryId = :categoryId GROUP BY c.categoryName")
	public int countBookByCategory(@Param("categoryId") int categoryId);

	public  List<Category> findByUserId(int userid);
	//@Query("SELECT COUNT(*) FROM Categroy c where c.User.id= :userid")
	@Query("SELECT COUNT(c) FROM Category c WHERE c.user.userid = :userid GROUP BY c.categoryName")
	public int countCategoryAddedByUser(@Param("userid") int userid);
	 
	
}
