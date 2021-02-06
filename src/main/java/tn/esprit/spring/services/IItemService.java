package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Item;

public interface IItemService {

	public Item addItem(Item item, int userid);
	public void deleteItem(int itemId);
	public List<Item> showItemByUser(int userid);
	public Item updateItem(Item itm);
	public List<Item> showAllItems();
	public int countItemByUser(int userid);
	public int countOfferByItem(int itemId);
	public List<Item> showCartAction(int itemId);
	
	
}
