package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Order;




public interface IOrderService {
	public void addOrder(Order order);
	public Order getOrderById(int id);
	public List<Order> getAllOrders();
}
