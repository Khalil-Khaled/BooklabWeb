package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Item;

@Repository
public interface IItemDAO extends JpaRepository<Item, Integer> {
	
	public  List<Item> findByUserId(int userid);
	@Query("Select * FROM Item i WHERE i.price < 30 and i.typeItem = 'Book' ORDER BY i.bookPublishDate")
	public List<Item> giftItems();
	
	@Query("SELECT COUNT(i) FROM Item i WHERE i.user.userid = :userid GROUP BY i.itemName")
	public int countItemAddedByUser(@Param("userid") int userid);
	 
	@Query("SELECT COUNT(o) FROM Item i JOIN i.offer o WHERE i.itemId = :itemId GROUP BY i.itemName")
	public int countOfferByItem(@Param("itemId") int itemId);

	@Query("SELECT * FROM Item i WHERE i.itemName = :itemName ORDER BY i.itemName")
	public Item findByName(@Param("itemName") String itemName);
	
	@Query("SELECT * FROM Item i WHERE i.itemId = :itemId ORDER BY i.itemName")
	public Item findById(@Param("itemId") int itemId);
	
}
