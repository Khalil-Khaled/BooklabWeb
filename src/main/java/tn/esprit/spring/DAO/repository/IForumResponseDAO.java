package tn.esprit.spring.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.ForumResponse;

@Repository
public interface IForumResponseDAO extends JpaRepository<ForumResponse, Integer> {

}
