package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Status;

@Repository
public interface IOfferDAO extends JpaRepository<Offer, Integer>{
	
	

	public List<Offer> findByOfferStatus (Status status);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1%")
	public List<Offer> searchAdmin (String keyword);
	
	@Query("SELECT o FROM Offer o WHERE o.descriptionOffer LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchCustomer (String keyword);
	
	@Query("select o from Offer o join o.items item where item.name LIKE %?1% AND o.offerStatus ='Validated'")
	public List<Offer> searchOfferbyItemName (String name);
	

}
