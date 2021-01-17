package tn.booklab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booklab.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
