package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.DAO.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {
        @Query(value = "SELECT sc from ShoppingCart sc where sc.creationDate = (select max(scc.creationDate) from Shopping_Cart scc where scc.userID = :userID)", nativeQuery = true)
        ShoppingCart getLastCart(@PathVariable("userID") int userID);


}
