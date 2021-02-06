package tn.esprit.spring.services;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Offer;
import tn.esprit.spring.DAO.entity.Status;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.IItemDAO;
import tn.esprit.spring.DAO.repository.IOfferDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;

@Service
public class OfferServicesImpl implements IOfferServices {
	
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private IOfferDAO iOfferDAO;
	
	@Autowired
	private IItemDAO itemDAO;

	@Override
	public Offer addOffer(Offer o) {
		User user = iUserRepository.findById(o.getUser().getUserid());
		System.out.println(user);
		o.setUser(user);
		Set<Item> items = new HashSet<>();
		for (Item item : o.getItems()) {
			System.out.println(item);
			Item item2 = itemDAO.findById(item.getItemId()).orElse(null);
			System.out.println(item2);
			items.add(item2);
		}
		System.out.println(items);
		o.setItems(items);
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
		return iUserRepository.findById(id).getOffer();
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

	@Override
	public List<Offer> getValidatedOffersByName(String name) {
		if (name != null)
			return iOfferDAO.searchOfferbyItemName(name);
		else
			return iOfferDAO.findByOfferStatus(Status.Validated);
	}

	@Override
	public Item getMostSoldItemPerYear() {
		List<Item> items =  iOfferDAO.getSoldItemsPerYear();
		Map<Integer, List<Item>> itemsMap = items.stream().collect(Collectors.groupingBy(Item::getItemId));
		int max=0;
		int index=0;
		for (Map.Entry<Integer, List<Item>> entrySet : itemsMap.entrySet()) {
			if (entrySet.getValue().size()>max) {
				max=entrySet.getValue().size();
				index=entrySet.getKey();
			}		
		}
		return itemsMap.get(index).get(0);
	}
	
	@Override
	public Item getLeastSoldItemPerYear() {
		List<Item> items =  iOfferDAO.getSoldItemsPerYear();
		Map<Integer, List<Item>> itemsMap = items.stream().collect(Collectors.groupingBy(Item::getItemId));
		int min=2147483647;
		int index=0;
		for (Map.Entry<Integer, List<Item>> entrySet : itemsMap.entrySet()) {
			if (entrySet.getValue().size()<min) {
				min=entrySet.getValue().size();
				index=entrySet.getKey();
			}		
		}
		return itemsMap.get(index).get(0);
	}
	
	public List<User> getTopSellersPerYear () {
		return iOfferDAO.getTopSellersPerYear();
	}
	
	
}
