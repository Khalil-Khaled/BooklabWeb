package tn.esprit.spring.DAO.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Order;


@Repository
public interface IOrderDAO extends JpaRepository<Order, Integer>{

}
