package com.transaction.dao;

public class TransactionDaoFactory {
	public static TransactionDao getInstance(){
		return new TransactionDaoImpl();
	}

}
