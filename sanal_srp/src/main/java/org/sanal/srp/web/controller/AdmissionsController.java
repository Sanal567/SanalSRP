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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionsController {

	// @Autowired
	// private EduClassService classService;
	@Autowired
	private StudentService studentService;

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