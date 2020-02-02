package spring_MVC;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an initbinder to convert inputs wioth white space to null
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor s= new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, s);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
	
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customerForm";
	}
	
	
	@RequestMapping("/processForm")
	public String letsProcess(@Valid @ModelAttribute("customer") Customer customer, BindingResult br) {
		//behind the scenes when in the form you click send, Spring will make getter and setter mnethods so here at this moment you can access these methods with data form the form
		
		System.out.println(br);
		
		
		if(br.hasErrors()) {
			
			return "customerForm";
		}
		else {
		
		return "customer_confirmation";
		}
	}
	
	

}
