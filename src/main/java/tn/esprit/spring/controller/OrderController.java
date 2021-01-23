package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Order;
import tn.esprit.spring.services.OrderService;


@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.POST ,value="/orders")
	public void addOrder(@RequestBody Order order ) {
		  orderService.addOrder(order);
	}
	@RequestMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
	@RequestMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }
}
