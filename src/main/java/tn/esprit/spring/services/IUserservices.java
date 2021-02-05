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
	public String UpdateRestPassword(int code,String password,int id);
	public void ifNotverifiedVerif(int id,String verification_code);
	public String VerifyMyaccount(User u, String verifcode);
	public boolean isVerified(String login, String pwd);
	public void AddCode(String code,User user_id) ;
}
