/**
 * 
 */
package org.sanal.srp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.querydsl.core.types.Predicate;

/**
 * @author Nalluru Sunil Reddy 14-01-19 03:19 PM
 *
 */

//@CacheConfig(cacheNames = "com.abc.domain.State")
//@Repository
//@NoRepositoryBean
public interface StudentRepository<Student, Integer extends Serializable>
		extends CrudRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {

//	@Cacheable("byStudentFirstNameAndLastName")
	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findDistinctStudentByFirstNameContainingOrLastNameContainingAllIgnoreCaseOrderByFirstNameAsc(
			String firstName, String lastName);

	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findByFirstNameIgnoreCaseContainingOrderByFirstNameAsc(String firstName);

	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
	List<Student> findByLastNameIgnoreCaseContainingOrderByLastNameAsc(String lastName);

//	,
//	@QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
//	@QueryHint(name = "org.hibernate.cacheRegion", value = "CacheRegion")
//	@Override
//	@QueryHints(value = { @QueryHint(name = "org.hibernate.cacheable", value = "true") }, forCounting = false)
//	List<Student> findAll(Predicate predicate);

	// Page<Student> findAll(Predicate predicate, Pageable pageable);
}
