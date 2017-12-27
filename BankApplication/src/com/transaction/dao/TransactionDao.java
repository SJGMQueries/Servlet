package com.transaction.dao;

import com.hibernate.pojo.TransactionDemo;

public interface TransactionDao {

	public void save(TransactionDemo t);

	public double availableAmount(String accNo);

	public void updateAmount(double amount, String accno);

}
