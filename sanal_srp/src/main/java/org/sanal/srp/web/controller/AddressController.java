package org.sanal.srp.web.controller;

import java.sql.Date;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.sanal.srp.entities.Address;
import org.sanal.srp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sunil Nalluru Date 3-1-19 12:04 AM
 */
//@RolesAllowed({"ROLE_ADMIN, ROLE_USER"})
@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/editAddress")
	public String editAddress(Model editAddress, @RequestParam("addressId") Integer addressId) {
		editAddress.addAttribute("address", addressService.getAddress(addressId));
		return "/address/editAddress";
	}

//	@Autowired
//	private AddessValidator addressValidator;  

	@PostMapping("/address/saveAddress")
	public String saveAddress(Model model, @ModelAttribute("address") Address address) {
		address = addressService.saveAddress(address);
		model.addAttribute("address", address);
		return "savedAddress";
	}

	@PostMapping("/address/updateAddress")
	public String updateAddress(Model model, @Valid Address address, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/address/editAddress";
		} else {
			address.setLastUpdatedBy(0);
			address.setLastUpdationDate(new Date(System.currentTimeMillis()));
			address = addressService.updateAddress(address);
			model.addAttribute("address", address);
			return "/address/updatedAddress";
		}
	}
}
