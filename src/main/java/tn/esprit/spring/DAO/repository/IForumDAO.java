package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.Status;

@Repository
public interface IForumDAO extends JpaRepository<Forum, Integer> {
	public List <Forum> findByStatus (Status status);
	
}
