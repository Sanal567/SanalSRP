package org.sanal.srp.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping({ "/", "/welcome**" })
	public String defaultPage() {
		return "home";
	}

	@GetMapping("/admin**")
	public String adminPage() {
		return "admin_home";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null)
			model.addAttribute("error", "Invalid username and password!");

		if (logout != null)
			model.addAttribute("msg", "You've been logged out successfully.");
		return "login";
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