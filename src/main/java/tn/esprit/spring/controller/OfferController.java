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

import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.services.IOfferServices;

@RestController
public class OfferController {

	@Autowired
	private IOfferServices iOfferServices;
	
	
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
	

}

