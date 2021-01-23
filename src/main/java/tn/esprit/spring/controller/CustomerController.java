package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Customer;
import tn.esprit.spring.services.CustomerService;


@RestController

public class CustomerController {
	 @Autowired
	  private  CustomerService customerService;

	 	@RequestMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerService.showAllCustomers();
	    }
	    
	 	@RequestMapping(method=RequestMethod.POST ,value="/customer/add")	  
	 	public Customer addCustomer(@RequestBody Customer customer) {
	        return  customerService.addCustomer(customer);
	    }
}
