package spring_MVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld";
	}
	
	// need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "hello";
	}
	
	//new controller method to read form data and add data to the model
/*	@RequestMapping("/processForm2")
	public String letsShopDude(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result="YOO"+ name;
		model.addAttribute("message",result);
		return "hello";
	}
	*/
	
	@RequestMapping("/processForm2")
	public String letsShopDude(@RequestParam("studentName") String name, Model model) {
		
		name = name.toUpperCase();
		String result="YOO"+ name;
		model.addAttribute("message",result);
		return "hello";
	}
	
	
}
