package tn.esprit.spring.DAO.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.*;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	// valide
	@Query("SELECT e FROM Event e WHERE e.name= :name ")
	public Event findByName(@Param("name") String name);

	// valide
	@Query("SELECT count(*) FROM Event e where FUNCTION('YEAR',e.begin_date) = FUNCTION('YEAR',current_date) AND e.user.id= :userId")
	public int countEventsByUserThisYear(@Param("userId") int userId);

	// valide
	@Query(value = "SELECT DISTINCT u FROM User u " 
			+ "join u.events ue " 
			+ "where ue = :event "
			+ "ORDER BY u.lastname")
	public List<User> participantsByEvent(@Param("event") Event event);

	//valide
	@Query(value = "SELECT count(*) from User u " 
			+ "join u.events ue " + "where ue = :event " 
			+ "ORDER BY u.lastname")
	public int nombreParticipantsByEvent(@Param("event") Event event);

	 @Query("Select "
	 + "DISTINCT evt from Event evt "
	 + "join evt.user ctm "
	 + "where ctm=:customer")
	 public List<Event> getAllEventsByCustomer(@Param("customer") User customer);

	 //valide
	 @Query("SELECT e.name FROM Event e order by e.name")
		public List<String> getEventNames();
	 
	 //valide
	 @Query("SELECT e.user.id,count(*)as nb FROM Event e group by e.user.id order by nb DESC")
		public List<String> getNbEventsByUser();
	 
	 //valide
	 @Query("SELECT e from Event e join e.users u where u=:user")
	 	public List<Event> participantEvents(@Param("user") User user);

}
