package org.sanal.srp.web.controller;

import org.sanal.srp.entities.Address;
import org.sanal.srp.entities.School;
import org.sanal.srp.entities.Student;
import org.sanal.srp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionsController {

	// @Autowired
	// private EduClassService classService;
	@Autowired
	private StudentService studentService;

	@GetMapping("/student/searchStudent")
	public ModelAndView showSearchForm() {
		ModelAndView searchStudent = new ModelAndView();
		searchStudent.addObject("student", new Student());
		// searchStudent.addV
		return searchStudent;
	}
	
	@GetMapping("/student/viewStudentDetails")
	public ModelAndView showStudentDetails(@RequestParam("studentId") Integer studentId) {
		
		ModelAndView studentDetails = new ModelAndView();
		if(studentId!=null && studentId.toString().length()!=0) { 
		studentDetails.addObject("student", studentService.findById(studentId));
		}
		else {
			System.out.println("studentId is null or it is empty string");
		}
		return studentDetails;
	}

	@PostMapping("/student/searchStudent")
	public ModelAndView searchResults(@ModelAttribute("student") Student student) {
		ModelAndView searchResults = new ModelAndView();

		if ((student.getFirstName() != null && student.getFirstName().trim().length() != 0)
				|| (student.getLastName() != null && student.getLastName().trim().length() != 0))
		{	
			searchResults.addObject("studentList", studentService.searchStudents(student));
			searchResults.setViewName("/student/searchResults");
			searchResults.addObject("firstName", student.getFirstName());
			searchResults.addObject("lastName", student.getLastName());
		}else {
			searchResults.addObject("error", "Please enter at least one field");
			searchResults.setViewName("/student/searchStudent");
		}
		return searchResults;
	}

	@GetMapping("/admission/admit")
	public ModelAndView loadAdmissionHome() {
		ModelAndView admissions = new ModelAndView();
		// admissions.addObject("allClasses", classService.getAllClasses());
		// admissions.setViewName("admissions");
		admissions.addObject("student", new Student());
		return admissions;
	}

	@PostMapping("/admission/admit")
	public String admit(@ModelAttribute("student") Student student) {

		// if(userService.findLoginName!=null)
		// studentValidator.validate(student);
		Address address = new Address();
		address.setAddressId(2);
		student.setPresentAddress(address);
		student.setPermanentAddress(address);
		student.setCommutingFrom(address);

		School school = new School();
		school.setSchoolId(3);
		student.setPreviousSchool(school);
		studentService.saveStudent(student);

		return "admissionSuccess";
	}

}