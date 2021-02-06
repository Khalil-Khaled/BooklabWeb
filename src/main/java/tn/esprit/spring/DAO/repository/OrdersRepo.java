package tn.esprit.spring.DAO.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.DAO.entity.Cart_Action;
import tn.esprit.spring.DAO.entity.Orders;

import java.util.List;



@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT o FROM Orders o left join ShoppingCart sc ON o.cartID.cartID= sc.cartID where sc.userID.id = :userID")
    List<Orders> getAllByUserId(@PathVariable("userID") int userID);

    @Query(value = "SELECT o FROM Orders o left join ShoppingCart sc ON o.cartID.cartID= sc.cartID join Cart_Action c ON sc.cartID = c.cartID.cartID join Item i on c.itemID.itemId = i.itemId where o.orderID = :orderID")
    Orders getOrderDetails(@PathVariable("orderID") int orderID);

    //Jointure
    @Query(value = "SELECT c FROM Orders o left join ShoppingCart sc ON o.cartID.cartID= sc.cartID join Cart_Action c ON sc.cartID = c.cartID.cartID join Item i on c.itemID.itemId = i.itemId where o.orderID = :orderID")
    List<Cart_Action> getItemIDsByOrderID(@PathVariable("orderID") int orderID);
}