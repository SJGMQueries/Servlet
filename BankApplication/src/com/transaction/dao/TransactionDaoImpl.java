package com.transaction.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.pojo.TransactionDemo;
import com.hibernate.util.HibernateUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public void save(TransactionDemo t) {
		SessionFactory factory = HibernateUtil.getobject();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
		session.close();

	}

	@Override
	public void updateAmount(double amount, String accNo) {


		SessionFactory factory = HibernateUtil.getobject();
		Session session = factory.openSession();
		Query qry = session
				.createQuery("update TransactionDemo t set t.amount=? where t.accountNo=?");
		qry.setParameter(0, amount);
		qry.setParameter(1, accNo);
		Transaction tx = session.beginTransaction();
		int i = qry.executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	public double availableAmount(String accNo) {
		SessionFactory factory = HibernateUtil.getobject();
		Session session = factory.openSession();
		Query qry = session
				.createQuery("select t.amount from TransactionDemo t where t.accountNo=?");
		qry.setParameter(0, accNo);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		double amount=0;
		return amount;
	}

}
