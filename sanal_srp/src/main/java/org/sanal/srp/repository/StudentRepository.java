/**
 * 
 */
package org.sanal.srp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.sanal.srp.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nalluru Sunil Reddy 14-01-19 03:19 PM
 *
 */
@Transactional
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findDistinctStudentByFirstNameContainingOrLastNameContainingAllIgnoreCaseOrderByFirstNameAsc(String firstName, String lastName);

	List<Student> findByFirstNameIgnoreCaseContainingOrderByFirstNameAsc(String firstName);

	List<Student> findByLastNameIgnoreCaseContainingOrderByLastNameAsc(String lastName);

}
