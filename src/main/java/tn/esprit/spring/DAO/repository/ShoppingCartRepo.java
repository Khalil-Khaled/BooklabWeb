package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.DAO.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer>{
        @Query(value = "SELECT sc from ShoppingCart sc where sc.creationDate = (select max(scc.creationDate) from ShoppingCart scc where scc.userID.id = :userID)")
        ShoppingCart getLastCart(@PathVariable("userID") int userID);

        //getTotal + reduction coupon
        @Query("select sum(i.price * ca.amount) from Cart_Action ca join Item i on ca.itemID.itemId = i.itemId where ca.cartID.cartID = :cartID")
        double getCartTotal(@PathVariable("cartID") int cartID);

}
