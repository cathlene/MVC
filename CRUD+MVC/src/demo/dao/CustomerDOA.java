package demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import demo.entity.Customer;


public interface CustomerDOA {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);

	public List<Customer> getCustomersByName(String theSearchName);

}
