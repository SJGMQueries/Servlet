package com.hms.Bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR_TABLE")
public class DoctorBO {
	@Id
	@Column(name = "D_ID")
	private int doctorId;
	@Column(name = "D_NAME")
	private String doctorName;
	@Column(name = "D_SPEC")
	private String DisSpecalist;
	@Column(name = "D_STATUS")
	private String status;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDisSpecalist() {
		return DisSpecalist;
	}

	public void setDisSpecalist(String disSpecalist) {
		DisSpecalist = disSpecalist;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
