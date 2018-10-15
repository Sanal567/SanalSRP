package edu.sanal.srp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sanal.srp.dao.EduClassDao;
import edu.sanal.srp.entities.EduClass;

@Repository
public class EduClassDaoImpl implements EduClassDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EduClass> getAllClasses() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM EduClass");
		List<EduClass> classes=(List<EduClass>)query.list();
		return classes;
	}

}