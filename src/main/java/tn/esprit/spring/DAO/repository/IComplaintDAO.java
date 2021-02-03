package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Complaint;
 

@Repository
public interface IComplaintDAO extends JpaRepository<Complaint, Integer> {
	public  List<Complaint> findByUserId(int userid);
	@Query("SELECT count(*) FROM Complaint c where c.user.id= :userid")
	public int countComplaintsByUser(@Param("userid") int userid);
	
}
