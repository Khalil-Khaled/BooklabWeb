package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Status;

@Repository
public interface IOfferDAO extends JpaRepository<Offer, Integer>{
	
	

	public List<Offer> findByOfferStatus (Status status);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1%")
	public List<Offer> searchAdmin (String keyword);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchCustomer (String keyword);
	
	@Query("select o from Offer o inner join o.items item where item.itemName LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchOfferbyItemName (String name);
	
	@Query(nativeQuery = true ,value= ""
			+ "select item "
			+ "from ("
				+ "select i,count(i) as itemCount "
				+ "from offer o natural join item i "
				+ "group by item.itemId "
				+ "having EXTRACT(YEAR ,o.purchaseDate)=EXTRACT(YEAR ,CURDATE()) and o.offerStatus ='Completed' "
				+ "order by itemCount Desc LIMIT 1)")
	public Item getMostSoldItemPerYear ();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
