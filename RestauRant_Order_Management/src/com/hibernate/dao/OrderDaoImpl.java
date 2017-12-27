package com.hibernate.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernate.pojo.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Order readOrder(String orderName) {
		Configuration conf = new Configuration();
		conf.configure("com/hibernate/config/hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Criteria crit = session.createCriteria(Order.class);
		Criterion c1 = Restrictions.eq("itemName", orderName);
		crit.add(c1);
		List list = crit.list();
		Iterator itr = list.iterator();
		Order o = null;
		while (itr.hasNext()) {
			o = (Order) itr.next();
			System.out.println(o.getId() + "\t" + o.getItemName() + "\t"
					+ o.getPrice() + "\t" + o.getItemCatagory() + "\t"
					+ o.getStatus());
		}
		return o;

	}

	@Override
	public Order readAvailableity() {
		Configuration conf = new Configuration();
		conf.configure("com/hibernate/config/hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("from Order o where o.status=?");
		qry.setParameter(0,"Available");
		List l = qry.list();
		Iterator itr = l.iterator();
		Order o = null;
		while (itr.hasNext()) {
			o = (Order) itr.next();
			System.out.println(o.getId() + "\t" + o.getItemName() + "\t"
					+ o.getPrice() + "\t" + o.getItemCatagory() + "\t"
					+ o.getStatus());
		}
		return o;
	}
}
