package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.entity.ShoppingCart;
 
@Repository
public interface ICouponAdminDAO extends JpaRepository<CouponAdmin, Integer> {
	@Query("SELECT c.percentOff from CouponAdmin c  WHERE c.name =: name")
	public int getPourcentage(String name) ;
	
}
