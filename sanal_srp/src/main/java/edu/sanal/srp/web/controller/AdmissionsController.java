package edu.sanal.srp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sanal.srp.service.EduClassService;

@Controller
public class AdmissionsController {
	
	@Autowired
	private EduClassService eduClassService;
	
	@RequestMapping("/admissions")
	public ModelAndView loadAdmissionHome() {
		ModelAndView admissionsView=new ModelAndView();
		admissionsView.addObject("allClasses", eduClassService.getAllClasses());
		admissionsView.setViewName("admissions");
		return admissionsView;
	}
	
	public EduClassService getEduClassService() {
		return eduClassService;
	}

	public void setEduClassService(EduClassService eduClassService) {
		this.eduClassService = eduClassService;
	}

}