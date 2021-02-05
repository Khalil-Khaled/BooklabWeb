package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Forum;
import tn.esprit.spring.DAO.entity.Status;
import tn.esprit.spring.DAO.entity.User;

@Repository
public interface IForumDAO extends JpaRepository<Forum, Integer> {
	
	public List <Forum> findByStatus (Status status);
	
	@Query ("select f from Forum f where f.publishDate = CURRENT_DATE and f.status= 'Validated'")
	public List<Forum> getMostRecentForums();
	
	@Query ("select distinct u "
			+ "from User u "
			+ "join Forum f "
			+ "where sum(f.downVotes)>1000 and EXTRACT(MONTH FROM f.publishDate)=EXTRACT(MONTH FROM CURRENT_DATE) and EXTRACT(Year FROM f.publishDate)=EXTRACT(Year FROM CURRENT_DATE)"
			+ "order by sum(f.downVotes) desc")
	public List<User> findUsersWithMostDownVotesByMonth();

	
}
