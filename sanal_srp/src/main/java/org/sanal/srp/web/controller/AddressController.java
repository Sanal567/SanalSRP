package org.sanal.srp.web.controller;

import javax.validation.Valid;

import org.sanal.srp.entities.Address;
import org.sanal.srp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sunil Nalluru Date 3-1-19 12:04 AM
 */
@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/editAddress")
	public String editAddress(Model editAddress, @RequestParam("addressId") Integer addressId) {

		Address address = null;
		if (addressId != null) {
			address = addressService.getAddress(addressId);
			editAddress.addAttribute("address", address);
			return "/address/editAddress";
		} else {
			editAddress.addAttribute("error", "Invalid URL: Please click a student to view address");
			return "/home";
		}
	}

//	@Autowired
//	private AddessValidator addressValidator;  ,BindingResult bindingResult, Error errors  

	@PostMapping("/address/saveAddress")
	public String saveAddress(Model model, @ModelAttribute("address") Address address) {
		address = addressService.saveAddress(address);
		model.addAttribute("address", address);
		return "viewAddress";
	}

	@PostMapping("/address/updateAddress")
	public String updateAddress(Model model, @Valid Address address, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/address/editAddress";
		else {
			addressService.updateAddress(address);
			model.addAttribute("address", address);
			return "viewAddress";
		}
	}
}
