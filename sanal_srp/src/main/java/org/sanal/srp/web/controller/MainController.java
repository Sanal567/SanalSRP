package org.sanal.srp.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping({ "/", "/welcome**" })
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}

	@GetMapping("/admin**")
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");
		return model;
	}

	@GetMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}

	// for 403 access denied page
	@GetMapping(value = "/403")
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;
	}

	/** Simulation of an exception. */
	@RequestMapping("/simulateError")
	public void simulateError() {
		throw new RuntimeException("This is a simulated error message");
	}

	/** Error page. */
//	@RequestMapping("/error")
//	public String error(HttpServletRequest request, Model model) {
//		model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
//		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//		StringBuilder errorMessage = new StringBuilder();
//		errorMessage.append("<ul>");
//		while (throwable != null) {
//			errorMessage.append("<li>").append(HtmlUtils.htmlEscape(throwable.getMessage())).append("</li>");
//			throwable = throwable.getCause();
//		}
//		errorMessage.append("</ul>");
//		model.addAttribute("errorMessage", errorMessage.toString());
//		return "error";
//	}

//	/** Error page. */
//	@RequestMapping("/403.html")
//	public String forbidden() {
//		return "403";
//	}

}