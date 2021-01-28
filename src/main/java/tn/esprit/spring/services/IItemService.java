package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.ItemB;

public interface IItemBService {

	public ItemB addItem(ItemB item);
	public String deleteItem(int itemId);
	public ItemB updateItem(ItemB itm);
	public List<ItemB> getItem(int itemId);
	
}
