package tn.esprit.spring.DAO.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.entity.Cart_Action;

@Repository
public interface Cart_ActionRepo extends JpaRepository<Cart_Action, Integer>{

        //JPQL
        @Query(value = "SELECT c from Cart_Action c where c.cartID = :cartID")
        ArrayList<Cart_Action> getItemsFromCart(@Param("cartID") int cartID);

        // Makhdmtsh
        @Query(value = "DELETE from Cart_Action c where c.itemID = :ItemID and c.cartID = :cartID")
        void removeItemFromCart(@Param("cartID") int cartID, @Param("ItemID") int itemID);
}
