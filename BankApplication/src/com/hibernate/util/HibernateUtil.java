package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;

	private HibernateUtil() {
		// no-op
	}

	public static synchronized SessionFactory getobject() {
		if (factory == null) {
			Configuration conf = new Configuration();
			conf.configure("com/hibernate/config/hibernate.cfg.xml");
			factory = conf.buildSessionFactory();
		}
		return factory;

	}

}
