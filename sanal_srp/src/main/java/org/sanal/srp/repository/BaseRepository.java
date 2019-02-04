/**
 * 
 */
package org.sanal.srp.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

/**
 * @author Nalluru Sunil Reddy
 *
 */
//@NoRepositoryBean
public interface BaseRepository/*
								 * <T, ID extends Serializable> extends JpaRepository<T, ID>,
								 * QuerydslPredicateExecutor<T>
								 */ {

	/*
	 * @Override List<T> findAll(Predicate predicate);
	 * 
	 * @Override List<T> findAll(Predicate predicate, Sort sort);
	 * 
	 * @Override List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);
	 * 
	 * @Override List<T> findAll(OrderSpecifier<?>... orders);
	 */}