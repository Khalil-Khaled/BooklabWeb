package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Book;

@Repository
public interface IItemDAO extends JpaRepository<Book, Integer> {

//	@Query("Select i from Itemb i where i.price<30 and i.item_role=admin order by i.price")
//	public List<Book> giftItems();
	
}
