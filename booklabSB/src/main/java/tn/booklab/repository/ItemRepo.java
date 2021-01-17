package tn.booklab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booklab.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
