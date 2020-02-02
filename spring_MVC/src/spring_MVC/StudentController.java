package spring_MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/hey")
	public String showForm(Model model) {
		
		Student student= new Student();
		model.addAttribute("student",student);
		return "StudentForm";
	}
	
	
	@RequestMapping("/processForm")
	public String letsProcess(@ModelAttribute("student") Student student) {
		//behind the scenes when in the form you click send, Spring will make getter and setter mnethods so here at this moment you can access these methods with data form the form
		return "confirmation";
	}
	
	
}
