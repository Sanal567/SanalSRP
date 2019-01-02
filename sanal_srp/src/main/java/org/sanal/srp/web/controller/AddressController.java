package org.sanal.srp.web.controller;

import org.sanal.srp.entities.Address;
import org.sanal.srp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nalluru Sunil Reddy
 *
 */
@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/editAddress")
	public ModelAndView editAddress(@RequestParam("addressId") Integer addressId) {
		ModelAndView editAddress = new ModelAndView();

		Address address = null;
		if (addressId != null) {
			address = addressService.getAddress(addressId);
			editAddress.addObject("address", address);
			return editAddress;
		} else
			return editAddress;
	}

}
