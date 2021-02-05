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
	public  List<Complaint> findByEventId(int eventId);
	@Query("SELECT count(*) FROM Complaint c where c.user.id= :userid")
	public int countComplaintsByUser(@Param("userid") int userid);
	@Query("SELECT c FROM Complaint c where c.user.id= :userid AND c.event.id= :eventId")
	public  List<Complaint> findByUserIdAndEventId(@Param("userid") int userid,@Param("eventId") int eventId);
	@Query("SELECT c FROM Complaint c where c.user.id= :userid AND c.offer.idOffer= :offerId")
	public  List<Complaint> findByUserIdAndOfferId(@Param("userid") int userid,@Param("offerId") int offerId);
	@Query("SELECT c FROM Complaint c where c.user.id= :userid AND c.order.orderID= :orderId")
	public  List<Complaint> findByUserIdAndOrderId(@Param("userid") int userid,@Param("orderId") int orderId);
}
