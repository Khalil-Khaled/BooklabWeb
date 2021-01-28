package tn.esprit.spring.DAO.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.DAO.entity.ItemB;
import tn.esprit.spring.DAO.entity.Role1;

public interface ItemRepository extends JpaRepository<ItemB, Integer>{

	public List<ItemB> findByItemRole(Role role);


}
