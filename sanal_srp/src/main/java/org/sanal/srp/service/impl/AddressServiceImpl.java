package org.sanal.srp.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.sanal.srp.entities.Address;
import org.sanal.srp.repository.AddressRepository;
import org.sanal.srp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sunil Nalluru 4-1-13 1:13 AM
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address getAddress(Integer addressId) {
		Optional<Address> optional = addressRepository.findById(addressId);
		Address address = null;
		if (optional.isPresent())
			address = optional.get();
		return address;
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public @Valid Address updateAddress(@Valid Address address) {
		return addressRepository.save(address);
	}

}
