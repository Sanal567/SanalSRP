package org.sanal.srp.repository;

import javax.transaction.Transactional;

import org.sanal.srp.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nalluru Sunil Reddy
 *
 */
@Transactional
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
