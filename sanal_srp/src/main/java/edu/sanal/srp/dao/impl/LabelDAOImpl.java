package edu.sanal.srp.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sanal.srp.entities.Label;
@Repository
@Transactional 
public class LabelDAOImpl {
	private SessionFactory sessionFactory;
	@Autowired
	public LabelDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Integer save() {
		Label label=new Label();
		label.setLabelName("SUPER");
		label.setCreationDate(new Date());
		Session session=sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		session.save(label);
		txn.commit();
		session.close();
		return label.getLabelId();
	}
	
}