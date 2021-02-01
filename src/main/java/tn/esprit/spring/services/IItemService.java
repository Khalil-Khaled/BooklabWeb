package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Item;

public interface IItemService {

	public Item addItem(Item item);
	public String deleteItem(int itemId);
	public Item updateItem(Item itm);
	public List<Item> getItem(int itemId);
	
}
