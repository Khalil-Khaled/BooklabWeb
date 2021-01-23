package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer c);
	public List<Customer> showAllCustomers();
}
