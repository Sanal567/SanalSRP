
/**
 * License of software
 *
 *
 */

package org.sanal.srp.web.controller;

import javax.inject.Inject;

import org.sanal.srp.entities.Student;
import org.sanal.srp.repository.StudentRepository;
import org.sanal.srp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.types.Predicate;

/**
 * @author Sunil Nalluru
 *
 */

@Controller
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(StudentController.class);
	private final String STUDENT_LIST_MODEL_NAME = "studentList";
	private final String STUDENT_SHOW_SEARCH_FORM = "/student/showSearchStudentsForm";

	@Inject
	private StudentService studentService;
	@Inject
	private StudentRepository studentRepository;

	@GetMapping("/student/viewStudentDetails")
	public String showStudentDetails(Model studentDetails, @RequestParam("studentId") Integer studentId) {
		if (studentId != null) {
			// studentId has to be positive value
			studentDetails.addAttribute("student", studentService.findById(studentId));
			return "studentDetails";
		} else {
			logger.debug("studentId is empty");
			studentDetails.addAttribute("error", "Invalid URL ");
			return "home";
		}

	}

	@GetMapping(STUDENT_SHOW_SEARCH_FORM)
	public String showSearchForm(Model model) {
		model.addAttribute("student", new Student());
		// searchStudent.addV
		return "/student/searchStudent";
	}

	@GetMapping("/student/searchPagination")
	public String searchStudentsPagination(Model model, @RequestParam("pageNo") Integer pageNo, Pageable pageable) {
		if (pageNo != null) {
			pageable = PageRequest.of(pageNo, 5, Sort.by("firstName").ascending());
			model.addAttribute(STUDENT_LIST_MODEL_NAME, studentRepository.findAllByCreatedBy(1, pageable));
			model.addAttribute("student", new Student());
			return "/student/searchResults";
		} else
			return "searchStudents";
	}

	@GetMapping("/student/searchQueryDsl")
	public String searchStudentsQueryDslWeb(Model model, @QuerydslPredicate(root = Student.class) Predicate predicate,
			@RequestParam MultiValueMap<String, String> parameters) {
		if (parameters.size() > 0) {
			model.addAttribute(STUDENT_LIST_MODEL_NAME, studentRepository.findAll(predicate));
			return "searchResults";
		} else {
			model.addAttribute("error", "Please enter at least one field");
			return "searchStudents";
		}
	}

	@GetMapping("/student/searchStudents")
	public String searchResults(@ModelAttribute("student") Student student, Model searchResults) {

		if ((student.getFirstName() != null && student.getFirstName().trim().length() != 0)
				|| (student.getLastName() != null && student.getLastName().trim().length() != 0)) {
			searchResults.addAttribute(STUDENT_LIST_MODEL_NAME, studentService.searchStudentsQueryDsl(student));
			searchResults.addAttribute("firstName", student.getFirstName());
			searchResults.addAttribute("lastName", student.getLastName());
			return "/student/searchResults";
		} else {
			searchResults.addAttribute("error", "Please enter at least one field");
			return STUDENT_SHOW_SEARCH_FORM;
		}
	}

}
