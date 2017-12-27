package com.hibernate.dao;

public class OrderDaoFactory {
	public static OrderDao getInstance() {
		return new OrderDaoImpl();

	}

}
