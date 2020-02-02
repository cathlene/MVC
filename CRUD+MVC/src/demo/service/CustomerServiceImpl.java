package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.CustomerDOA;
import demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject the customer doa
	@Autowired
	private CustomerDOA customerDOA;
	
	@Override
	@Transactional // dit doet start. close en commit allemaal zelf
	public List<Customer> getCustomers() {
	return customerDOA.getCustomers();
		
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDOA.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDOA.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDOA.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> getCustomersByName(String theSearchName) {
		return customerDOA.getCustomersByName(theSearchName);
	}

}
