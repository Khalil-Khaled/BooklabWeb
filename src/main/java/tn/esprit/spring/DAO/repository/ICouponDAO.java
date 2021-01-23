package tn.esprit.spring.DAO.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Coupon;

 
@Repository
public interface ICouponDAO extends JpaRepository<Coupon, Integer> {
}
