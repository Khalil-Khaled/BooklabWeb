package tn.esprit.spring.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.ItemB;
import tn.esprit.spring.DAO.repository.ItemRepository;


@Service
public class ItemService implements IItemBService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public ItemB addItem(ItemB item) {
		
		
		return itemRepository.save(item);
	}

	@Override
	public String deleteItem(int itemId) {
		itemRepository.deleteById(itemId);
		return ("Item "+itemId+" is deleted !");
	}

	@Override
	public ItemB updateItem(ItemB itm) {
	
		ItemB item= itemRepository.findById(itm.getItemId()).orElse(null);
		if(!(itm.getItemName()==null))
			item.setItemName(itm.getItemName());
		return itemRepository.save(item);
	}

	@Override
	public List<ItemB> getItem(int itemId) {
		
		return itemRepository.findAll();
	}
	
}
