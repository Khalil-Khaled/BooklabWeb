package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Status;
import tn.esprit.spring.DAO.repository.ICustomerDAO;
import tn.esprit.spring.DAO.repository.IOfferDAO;

@Service
public class OfferServicesImpl implements IOfferServices {
	
	@Autowired
	private ICustomerDAO iCustomerDAO;
	@Autowired
	private IOfferDAO iOfferDAO;

	@Override
	public Offer addOffer(Offer o) {
		
		return iOfferDAO.save(o);
	}

	@Override
	public String removeOffer(int id) {
		iOfferDAO.deleteById(id);;
		return ("Offer "+id+" deleted");
	}

	@Override
	public Offer getOffer(int id) {
		return iOfferDAO.findById(id).orElse(null);
	}

	@Override
	public List<Offer> getAllOffers(String keyword) {
		if (keyword != null)
			return iOfferDAO.searchAdmin(keyword);
		return iOfferDAO.findAll();
	}

	@Override
	public List<Offer> getMyOffers(int id) {
		return iCustomerDAO.findById(id).orElse(null).getOffer();
	}

	@Override
	public List<Offer> getValidatedOffers(String keyword) {
		if (keyword != null)
			return iOfferDAO.searchCustomer(keyword);
		return iOfferDAO.findByOfferStatus(Status.Validated);
	}

	@Override
	public Offer updateOffer(Offer o) {
		Offer offer = iOfferDAO.findById(o.getIdOffer()).orElse(null);
		if (!(o.getDescriptionOffer()== null))
			offer.setDescriptionOffer(o.getDescriptionOffer());
		if (!(o.getOfferStatus()== null))
			offer.setOfferStatus(o.getOfferStatus());
		return iOfferDAO.save(offer);
	}
	
	
}
