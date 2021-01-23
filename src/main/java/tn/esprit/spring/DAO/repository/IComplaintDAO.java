package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Complaint;
 

@Repository
public interface IComplaintDAO extends JpaRepository<Complaint, Integer> {
	public  List<Complaint> findByCustomerUserid(int userid);

}
