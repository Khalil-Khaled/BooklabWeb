package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.DAO.entity.User;
import tn.esprit.spring.services.UserServices;
import tn.esprit.spring.services.IUserservices;


@RestController
public class UserController {
	@Autowired
	private IUserservices userservices;

	@PostMapping("/adduser")
	public User addCustomer(@RequestBody User u){
		return userservices.addCustomer(u);
	}
	  @GetMapping("/showusers")
	    public List<User> getAllComplaints() {
	        return userservices.showAllCustomer();
	    }
	  @GetMapping("/showadmin")
	    public List<User> showadmin() {
	        return userservices.showAlladmin();
		    } 
	  	@GetMapping("/infosuser/{id}")
	    @ResponseBody
	    public User userInfo( @PathVariable("id") int id) {
	        return userservices.GetUser(id);
	  	}
	    @DeleteMapping("/deleteuser/{id}")
	    @ResponseBody
	    public String SupprimerUser(@PathVariable("id") int id) {
	    	userservices.Delete(id);
	        return "User Deleted successfully !";
	    }
	  /// Sign up user
	    @PostMapping("/signup")
	    @ResponseBody
	    public String Adduser(@RequestBody User us) {
	    	return userservices.Signup(us);

	    }
	    // Login
	    @PostMapping("/au")
	    @ResponseBody
	    public User Login(@RequestBody User usr) {
	    	
	        return userservices.Authority(usr.getUsername(), usr.getPassword());
	    }
	  //update
	    @PutMapping("/modify")
	    @ResponseBody
	    public User modifyUser(@RequestBody User user) {
	        return userservices.Update(user);
	    }
	    
	    @GetMapping("/VerifyAccount")
	    @ResponseBody
	    public String verify(User u,@RequestParam String Code) {
	    	System.out.println(Code);
	        return userservices.VerifyMyaccount(u, Code);
	    }
	    
	    @GetMapping("/isVerified")
	    @ResponseBody
	    public boolean isverify( User u) {
	        return userservices.isVerified(u.getUsername(),u.getPassword());
	    }
	    

}
