package tn.esprit.spring.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.services.*;

@RestController
public class ItemController {

	
	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService){
		this.itemService = itemService;
	}
	
	@PostMapping("additem")
	public Item addItem (@RequestBody Item item, @PathVariable("userid") int userid){
		return itemService.addItem(item, userid);
	}
	
	@PutMapping("updateitem")
	public void updateItem(@RequestBody Item item){
		itemService.updateItem(item);
	}
	
	@DeleteMapping("deleteitem")
	public void deleteItem(@PathVariable("itemId") int itemId){
		itemService.deleteItem(itemId);
	}
	
	@GetMapping("finditem")
	public List<Item>  getAllItem(){
		return itemService.showAllItems();
	}

	@GetMapping("cartaction")
	public List<Item> getCartByItem(@PathVariable("itemId") int itemId){
		return itemService.showCartAction(itemId);
	}
	
	@GetMapping("itembyuser")
	public int numberOfItems(@PathVariable("userid") int userid){
		return itemService.countItemByUser(userid);
	}
	
	@GetMapping("showitembyUser")
	public List<Item> getItemByUser(@PathVariable("userid") int userid){
		return itemService.showItemByUser(userid);
	}
	
	@GetMapping("offerbyitem")
	public int numberOfOffers(@PathVariable("itemId") int itemId){
		return itemService.countOfferByItem(itemId);
	}
	
	
}
