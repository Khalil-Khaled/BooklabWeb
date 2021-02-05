package tn.esprit.spring.services;


import tn.esprit.spring.DAO.entity.Cart_Action;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Orders;

import java.util.List;



public interface IOrdersService<E> {
    public Orders addOrder(E e);
    public List<E> getAllOrders(int userID);
    public Orders getOrderById(int idOrder);
    public List<Cart_Action> getItemsByOrder(int orderID);


}
