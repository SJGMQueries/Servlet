package com.hms.dao;

public class HospitalityManagementDaoFactory {
	public static HospitalityManagementDao getInstance() {
		return new HospitalityManagementDaoImpl();
	}

}
