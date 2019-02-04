/**
 * 
 */
package org.sanal.srp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.sanal.srp.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Predicate;

/**
 * @author Nalluru Sunil Reddy 14-01-19 03:19 PM
 *
 */

//@CacheConfig(cacheNames = "com.abc.domain.State")
@Repository
public interface StudentRepository
		extends PagingAndSortingRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {

//	@Cacheable("byStudentFirstNameAndLastName")
	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findDistinctStudentByFirstNameContainingOrLastNameContainingAllIgnoreCaseOrderByFirstNameAsc(
			String firstName, String lastName);

	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findByFirstNameIgnoreCaseContainingOrderByFirstNameAsc(String firstName);

	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findByLastNameIgnoreCaseContainingOrderByLastNameAsc(String lastName);

//	@QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
//	@QueryHint(name = "org.hibernate.cacheRegion", value = "CacheRegion")
	@Override
	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findAll(Predicate predicate);

	List<Student> findAllByCreatedBy(Integer i, Pageable pageable);

// Page<Student> findAll(Predicate predicate, Pageable pageable);
}
