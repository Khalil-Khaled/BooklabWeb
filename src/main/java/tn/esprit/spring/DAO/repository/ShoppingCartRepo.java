package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.entity.ShoppingCart;


@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer>{
        @Query(value = "SELECT * from ShoppingCart where userID = :userID and creationDate = (select max(creationDate) from ShoppingCart)", nativeQuery = true)
        ShoppingCart getLastCart(@Param("userID") int userID);

        
}
