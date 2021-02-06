package tn.esprit.spring.DAO.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.entity.ShoppingCart;
 
@Repository
public interface ICouponAdminDAO extends JpaRepository<CouponAdmin, Integer> {
	@Query("SELECT c.percentOff from CouponAdmin c  WHERE c.shoppingCart.cartID =: scId")
	public int getPourcentage(int scId) ;
	
	@Query("SELECT c.expiration_date FROM CouponAdmin c where  c.expiration_date = :expDate")
	public Date checkDate(@Param("expDate") Date expDate);
	
	@Query("SELECT c.name FROM CouponAdmin c WHERE c.name= :name ")
	public String findCouponByName(@Param("name") String name);
	
}
