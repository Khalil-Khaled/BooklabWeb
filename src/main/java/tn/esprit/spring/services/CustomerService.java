package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Customer;
import tn.esprit.spring.DAO.repository.ICustomerDAO;


@Service
public class CustomerService implements ICustomerService{
	@Autowired
	ICustomerDAO customerRepository;
	@Override
	public Customer addCustomer(Customer c) {
		return customerRepository.save(c);
	}
	@Override
	public List<Customer> showAllCustomers() {
		List<Customer> allCustomer= new ArrayList<>();
		customerRepository.findAll().forEach(allCustomer::add);
		  return allCustomer;
	}
	
}
