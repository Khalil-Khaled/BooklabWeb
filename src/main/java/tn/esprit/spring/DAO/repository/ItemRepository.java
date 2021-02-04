package tn.esprit.spring.DAO.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.DAO.entity.Item;
import tn.esprit.spring.DAO.entity.Role;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	public List<Item> findByItemRole(Role role);


}
