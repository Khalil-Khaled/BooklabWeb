package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.DAO.entity.User;

public interface IUserservices{
	public User addCustomer(User u);
	public List<User> showAllCustomer();
	public List<User> showAlladmin() ;
	public User GetUser(int id);
	public void Delete(int id);
	public void mailling(String mail,String message);
	public String Signup(User us);
	public User Authority(String login, String password);
	public User Update(User us);
}
