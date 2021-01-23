package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Order;
import tn.esprit.spring.DAO.repository.IOrderDAO;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderDAO orderRepository;
	
	@Override
	public void addOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public Order getOrderById(int id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> allOrders= new ArrayList<>();
		orderRepository.findAll().forEach(allOrders::add);
		  return allOrders;
	}

	public double calcTotalAfterdDiscount(Order order) {
		return order.getTotalPrice()-(order.getTotalPrice()*(order.getDiscount()/100));
	}
}
