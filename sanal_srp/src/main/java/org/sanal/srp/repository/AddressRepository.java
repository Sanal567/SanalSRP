package org.sanal.srp.repository;

import org.sanal.srp.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nalluru Sunil Reddy
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
