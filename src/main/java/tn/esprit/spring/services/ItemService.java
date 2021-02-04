package tn.esprit.spring.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.repository.IItemDAO;



@Service
public class ItemService implements IItemService{
	
	@Autowired
	private IItemDAO itemRepository;
	
	@Override
	public Item addItem(Item item) {
		
		
		return itemRepository.save(item);
	}

	@Override
	public String deleteItem(int itemId) {
		itemRepository.deleteById(itemId);
		return ("Item "+itemId+" is deleted !");
	}

	@Override
	public Item updateItem(Item itm) {
	
		Item item= itemRepository.findById(itm.getItemId()).orElse(null);
		if(!(itm.getItemName()==null))
			item.setItemName(itm.getItemName());
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getItem(int itemId) {
		
		return itemRepository.findAll();
	}
	
}
