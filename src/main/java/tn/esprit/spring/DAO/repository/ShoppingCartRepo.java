package tn.esprit.spring.DAO.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.DAO.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {
        @Query("SELECT sc from ShoppingCart sc join sc.userID u where u.id = ?1 and sc.creationDate = (select max(scc.creationDate) from ShoppingCart scc join scc.userID user)")
        ShoppingCart getLastCart(int userID);


}
