package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Orders;
import tn.esprit.spring.DAO.repository.OrdersRepo;

import java.util.List;

@Service
public class OrdersService implements IOrdersService<Orders>{
    @Autowired
    private OrdersRepo repo;

    @Override
    public Orders addOrder(Orders order) {
        return repo.save(order);
    }

    @Override
    public List<Orders> getAllOrders(int userID) {
        return repo.getAllByUserId(userID);
    }

    @Override
    public Orders getOrderById(int idOrder) {
        return repo.getOrderDetails(idOrder);
    }

    @Override
    public List<Item> getItemsByOrder(int orderID) {
        return repo.getItemIDsByOrderID(orderID);
    }

}
