package com.hibernate.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderDetails {
	public static void main(String[] args) {
		Order o1 = new Order();
		o1.setId(111);
		o1.setItemName("chicken biriyani");
		o1.setItemCatagory("non veg");
		o1.setPrice(120);
		o1.setStatus("Available");
		Order o2 = new Order();
		o2.setId(112);
		o2.setItemName("chilly chicken");
		o2.setItemCatagory("non veg");
		o2.setPrice(100);
		o2.setStatus("not Available");
		Order o3 = new Order();
		o3.setId(132);
		o3.setItemName("Tanduri chicken");
		o3.setItemCatagory("non veg");
		o3.setPrice(120);
		o3.setStatus("Available");
		Order o4 = new Order();
		o4.setId(141);
		o4.setItemName("chilly paneer");
		o4.setItemCatagory("veg");
		o4.setPrice(100);
		o4.setStatus("Available");
		Order o5 = new Order();
		o5.setId(117);
		o5.setItemName("paneer mughlai");
		o5.setItemCatagory("veg");
		o5.setPrice(110);
		o5.setStatus("not Available");

		Order o6 = new Order();
		o6.setId(143);
		o6.setItemName("natkodi grills");
		o6.setItemCatagory("non veg");
		o6.setPrice(140);
		o6.setStatus("not Available");

		Configuration conf = new Configuration();
		conf.configure("com/hibernate/config/hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(o1);
		session.save(o2);
		session.save(o3);
		session.save(o4);
		session.save(o5);
		session.save(o6);
		tx.commit();
		session.close();

	}

}
