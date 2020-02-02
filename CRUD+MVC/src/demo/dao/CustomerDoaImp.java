package demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.entity.Customer;

@Repository // to refer to DOA implementations
public class CustomerDoaImp implements CustomerDOA {

	//need to inject the session factory from the config files <bean> the bean id is the same name as here
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		//sort also
		Query<Customer> query= session.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer c=session.get(Customer.class, id);
		return c;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Customer c= this.getCustomer(theId);
		session.delete(c);
		//Query query= session.createQuery("delete Customer where id:=customerId");
		//query.setParameter("customerId", theId);
		//query.executeUpdate();
	}

	@Override
	public List<Customer> getCustomersByName(String theSearchName) {
		Session session = sessionFactory.getCurrentSession();
		  Query theQuery = null;
	   
	        // only search by name if theSearchName is not empty
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =session.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
		
	}

}
