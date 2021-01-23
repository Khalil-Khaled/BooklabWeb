package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Item;

@Repository
public interface IItemDAO extends JpaRepository<Item, Integer> {

}
