package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.User;

public interface IOfferServices {
	public Offer addOffer (Offer o);
	public String removeOffer (int id);
	public Offer getOffer (int id);
	public List<Offer> getAllOffers (String keyword);
	public List<Offer> getMyOffers (int id);
	public List<Offer> getValidatedOffers (String keyword);
	public List<Offer> getValidatedOffersByName (String name);
	public Offer updateOffer (Offer o);
	
	public Item getMostSoldItemPerYear();
	public Item getLeastSoldItemPerYear();
	public List<User> getTopSellersPerYear();
	
}
