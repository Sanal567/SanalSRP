/**
 * License of software
 */
package org.sanal.srp.web.controller;

import org.sanal.srp.entities.Student;
import org.sanal.srp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nalluru Sunil Reddy
 *
 */

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student/viewStudentDetails")
	public ModelAndView showStudentDetails(@RequestParam("studentId") Integer studentId) {

		ModelAndView studentDetails = new ModelAndView();
		if (studentId.toString().length() != 0) {
			studentDetails.addObject("student", studentService.findById(studentId));
		} else {
			System.out.println("studentId is empty string");
		}
		return studentDetails;
	}

	@GetMapping("/student/searchStudent")
	public ModelAndView showSearchForm() {
		ModelAndView searchStudent = new ModelAndView();
		searchStudent.addObject("student", new Student());
		// searchStudent.addV
		return searchStudent;
	}

	@PostMapping("/student/searchStudent")
	public ModelAndView searchResults(@ModelAttribute("student") Student student) {
		ModelAndView searchResults = new ModelAndView();

		if ((student.getFirstName() != null && student.getFirstName().trim().length() != 0)
				|| (student.getLastName() != null && student.getLastName().trim().length() != 0)) {
			searchResults.addObject("studentList", studentService.searchStudents(student));
			searchResults.setViewName("/student/searchResults");
			searchResults.addObject("firstName", student.getFirstName());
			searchResults.addObject("lastName", student.getLastName());
		} else {
			searchResults.addObject("error", "Please enter at least one field");
			searchResults.setViewName("/student/searchStudent");
		}
		return searchResults;
	}

}
