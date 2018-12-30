/**
 * 
 */
package org.sanal.srp.repository;

import java.util.List;

import org.sanal.srp.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nalluru Sunil Reddy
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);

	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String lastName);

}
