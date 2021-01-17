package tn.booklab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.booklab.entities.Cart_Action;

@Repository
public interface Cart_ActionRepo extends JpaRepository<Cart_Action, Integer>{
        @Query(value = "SELECT * from Cart_Action where cartID = :cartID ", nativeQuery = true)
        ArrayList<Cart_Action> getItemsFromCart(@Param("cartID") int cartID);

        @Query(value = "DELETE from Cart_Action where ItemID = :ItemID and cartID = :cartID", nativeQuery = true)
        void delete(@Param("ItemID") int itemID, @Param("cartID") int cartID);
}
