package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Cart_Action;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.services.Cart_ActionImp;
import tn.esprit.spring.services.IOfferServices;
import tn.esprit.spring.services.ShoppingCartImp;

@RestController
public class OfferController {

	@Autowired
	private IOfferServices iOfferServices;
	
	@Autowired
	private ShoppingCartImp serviceShoppingCart;
	
	@Autowired
    private Cart_ActionImp cartActionService;
	
	
	@PostMapping("/offers/add")
	public Offer addOffer (@RequestBody Offer o){
		return iOfferServices.addOffer(o);
	}
	
	@PostMapping("/admin/offers/update")
	public void updateOfferStatus (@RequestBody Offer o) {
		iOfferServices.updateOffer(o);
	}
	
	@DeleteMapping("/admin/offers/delete/{id}")
	public void removeOffer (@PathVariable int id){
		iOfferServices.removeOffer(id);
	}
	
	@GetMapping("/offers/{id}")
	public Offer getOffer (@PathVariable int id) {
		return iOfferServices.getOffer(id);
	}
	
	@GetMapping("/admin/offers")
	public List<Offer> getAllOffers (@Param("keyword") String keyword) {
		return iOfferServices.getAllOffers(keyword);
	}
	
	@GetMapping("/offers")
	public List<Offer> getValidatedOffers (@Param("keyword") String keyword){
		return iOfferServices.getValidatedOffers(keyword);
	}
	
	@GetMapping("/myOffers/{idClient}")
	public List<Offer> getMyOffers (@PathVariable int idClient) {
		return iOfferServices.getMyOffers(idClient);
	}
	
	
	@PostMapping ("/offers/addToCart/{userID}/{offerID}")
	public ShoppingCart addOfferItemsToShoppingCart (@PathVariable int userID, @PathVariable int offerID) {
		ShoppingCart sc = serviceShoppingCart.getLatestSC(userID);
		Offer offer = iOfferServices.getOffer(offerID);
		for (Item item : offer.getItems()) {
			Cart_Action ca = new Cart_Action();
			ca.setAmount(1);
			ca.setCartID(sc);
			ca.setItemID(item);
			cartActionService.save(ca);
		}
		return sc;
	}
	

}

