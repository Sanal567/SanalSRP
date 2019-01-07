package org.sanal.srp.service;

import javax.validation.Valid;

import org.sanal.srp.entities.Address;

/**
 * @author Nalluru Sunil Reddy
 *
 */
public interface AddressService {

	public Address getAddress(Integer addressId);
	public Address saveAddress(Address address);
	public Address updateAddress(@Valid Address address);

}
