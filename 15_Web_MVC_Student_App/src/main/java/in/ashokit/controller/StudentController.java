package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	// this method is used to load the page
	public String loadIndexPage(Model model) {

		forminitBinding(model);

		return "index";
	}

	private void forminitBinding(Model model) {
		model.addAttribute("student", new Student());

		model.addAttribute("courses", service.getCourses());

		model.addAttribute("timings", service.getTimings());
	}

	@PostMapping("/save")
	// this method is used to handle the submit button
	public String saveStudent(Student s, Model model) {

		System.out.println(s);
		forminitBinding(model);
	
		boolean status = service.saveStudent(s);
		if(status) {
			model.addAttribute("msg", "Data Saved...");
		}else {
			System.out.println("Data not saved...");
		}
	

		return "index";
	}
}
