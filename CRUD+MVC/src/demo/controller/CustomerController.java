package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.dao.CustomerDOA;
import demo.entity.Customer;
import demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		//get customers from the service
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers",customers);
		return "list-customer";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		customerService.deleteCustomer(theId);	
		
		// send over to our form		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {
		
			List<Customer> customers= customerService.getCustomersByName(theSearchName);
			theModel.addAttribute("customers", customers);
		
		// send over to our form		
		return "list-customer";
	}
	
}
