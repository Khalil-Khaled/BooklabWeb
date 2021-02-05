package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Status;
import tn.esprit.spring.DAO.entity.User;

@Repository
public interface IOfferDAO extends JpaRepository<Offer, Integer>{
	
	

	public List<Offer> findByOfferStatus (Status status);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1%")
	public List<Offer> searchAdmin (String keyword);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchCustomer (String keyword);
	
	@Query("select o from Offer o inner join o.items item where item.itemName LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchOfferbyItemName (String name);
	
	@Query("select item "
			+ "from Offer o join o.items item "
			+ "where EXTRACT(YEAR FROM o.purchaseDate)=EXTRACT(YEAR FROM CURRENT_DATE) and o.offerStatus ='Completed'")
	public List<Item> getSoldItemsPerYear ();

	@Query (nativeQuery=true, value=""
			+ "select u.* "
			+ "from user u "
			+ "join offer o on u.id=o.user_id "
			+ "where sum(priceOffer) in ("
				+ "select sum(priceOffer) as total"
				+ "from offer off "
				+ "join user us on on off.user_id=us.id"
				+ "where EXTRACT(Year FROM off.purchaseDate)=EXTRACT(Year FROM CURRENT_DATE) and off.offerStatus ='Completed')"
				+ "order by total desc limit 10)")
	public List<User> getTopSellersPerYear ();
	
	
	
	
	
	
	
	
	
	
}
