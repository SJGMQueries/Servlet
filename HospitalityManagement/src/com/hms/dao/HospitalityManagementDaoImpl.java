package com.hms.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;

public class HospitalityManagementDaoImpl implements HospitalityManagementDao {

	@Override
	public List<String> conformAppointment(String disease) {

		SessionFactory factory = HibernateUtil.getobject();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		final String QRY_TO_GET_APPOINTMENT_CHECK = "select d.doctorName from DoctorBO d where d.DisSpecalist=?";
		Query qry = session.createQuery(QRY_TO_GET_APPOINTMENT_CHECK);
		qry.setParameter(0, disease);
		List<String> l = qry.list();
		return l;

	}

	@Override
	public String getStatus(String docterName) {

		SessionFactory factory = HibernateUtil.getobject();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		final String check_Status = "select d.status from DoctorBO d where d.doctorName=?";
		Query qry = session.createQuery(check_Status);
		qry.setParameter(0, docterName);
		List<String> list = qry.list();
		Iterator<String> itr = list.iterator();
		String getStatus = null;
		while (itr.hasNext()) {
			getStatus = (String) itr.next();
		}
		return getStatus;
	}

}
