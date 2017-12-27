package com.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction_Table")
public class TransactionDemo {
	@Id
	@Column(name = "sId")
	private int serailId;
	@Column(name = "accNo")
	private String accountNo;
	private String personName;
	private double amount;

	public int getSerailId() {
		return serailId;
	}

	public void setSerailId(int serailId) {
		this.serailId = serailId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
