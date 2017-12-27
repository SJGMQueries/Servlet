package com.hms.dao;

import java.util.List;

public interface HospitalityManagementDao {
	public List conformAppointment(String disease);
	public String getStatus(String docterName);

}
