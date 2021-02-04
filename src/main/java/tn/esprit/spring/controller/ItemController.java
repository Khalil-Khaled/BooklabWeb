package tn.esprit.spring.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.services.*;

@RestController
public class ItemController {

	@Autowired
	private ItemService iItemService;
	
	@PostMapping("/item/add")
	public Item addItem(@RequestBody Item itm){
		return iItemService.addItem(itm);
	}
	
	@PostMapping("/admin/item/update")
	public void updateItem(Item itm){
		iItemService.updateItem(itm);
	}
	
	@PostMapping("/admin/item/delete/itemId")
	public void deleteItem(@PathVariable int itemId){
		iItemService.deleteItem(itemId);
	}
	
	@GetMapping("/item/id")
	public List<Item>  getItem(@PathVariable int itemId){
		return iItemService.getItem(itemId);
	}
	
}
