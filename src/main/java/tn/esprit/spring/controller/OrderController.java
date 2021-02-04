package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Orders;
import tn.esprit.spring.services.OrdersService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrdersService orderService;
	
	@PostMapping("/add")
	public Orders addOrder(@RequestBody Orders order ) {
		 return orderService.addOrder(order);
	}
	@GetMapping("/get/{userID}")
    public List<Orders> getAllOrders(@PathVariable("userID") int userID) {
        return orderService.getAllOrders(userID);
    }

	@GetMapping("/orderDetails/{orderId}")
    public Orders getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }

	@GetMapping("/getitems/{orderId}")
	public List<Item> getItemsByOrder(@PathVariable int orderId) {
		return orderService.getItemsByOrder(orderId);
	}
}
