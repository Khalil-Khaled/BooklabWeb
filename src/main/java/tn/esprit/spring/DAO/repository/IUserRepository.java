package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.DAO.entity.User;
@Repository
public interface IUserRepository extends CrudRepository<User,Integer>{
	@Query("SELECT u FROM User u WHERE u.role='admin'")
	public List<User> adminlist();
	
	User findById(int id);
	
	@Query("select case when count(u) > 0 then true else false end from User u WHERE u.email= :email OR u.username = :username")
	public boolean Existmail(@Param("email") String email,@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email= :email AND u.id = :id")
	User findByEmail(@Param("email") String login,@Param("id") int id);
	
	@Query("SELECT u FROM User u WHERE u.username= :username")
	public User Auth(@Param("username") String username);
	
	@Query("select u from User u join Verification_Code v on u.id=v.user_id WHERE u.username= :username")
	User isverified(String login);
	
	@Query("SELECT u.id FROM User u WHERE u.username= :username")
	long SelectByid(@Param("username") String username);
	
}
