package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Offer;

public interface IOfferServices {
	public Offer addOffer (Offer o);
	
	public String removeOffer (int id);
	
	public Offer getOffer (int id);
	public List<Offer> getAllOffers (String keyword);
	public List<Offer> getMyOffers (int id);
	public List<Offer> getValidatedOffers (String keyword);
	
	public Offer updateOffer (Offer o);
	
}

