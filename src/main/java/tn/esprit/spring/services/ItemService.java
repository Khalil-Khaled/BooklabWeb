package tn.esprit.spring.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.DAO.repository.CategoryRepository;
import tn.esprit.spring.DAO.repository.IItemDAO;
import tn.esprit.spring.DAO.repository.IUserRepository;



@Service
public class ItemService implements IItemService{
	
	@Autowired
	private IItemDAO itemRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private IUserRepository userRepository;
	

	@Override
	public Item addItem(Item item, int userid) {
		User user =userRepository.findById(userid);
		item.setUser(user);
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(int itemId) {
		itemRepository.deleteById(itemId);
	
	}

	@Override
	public List<Item> showItemByUser(int userid) {
		List<Item> itemsByUser= new ArrayList<>();
		  itemRepository.findByUserId(userid).forEach(itemsByUser::add);
		  return itemsByUser;
	}


	@Override
	public Item updateItem(Item itm) {
		return itemRepository.save(itm);
	}


	@Override
	public List<Item> showAllItems() {
		List<Item> allItems=new ArrayList<>();
		itemRepository.findAll().forEach(allItems::add);
		return allItems;
	}

	@Override
	public int countItemByUser(int userid) {
		return itemRepository.countItemAddedByUser(userid);
	}

	@Override
	public int countOfferByItem(int itemId) {
		return itemRepository.countOfferByItem(itemId);
	}

	@Override
	public List<Item> showCartAction(int itemId) {

		List<Item> itemsByCart= new ArrayList<>();
		  itemRepository.findById(itemId);
		  return itemsByCart;
	}

	


}
