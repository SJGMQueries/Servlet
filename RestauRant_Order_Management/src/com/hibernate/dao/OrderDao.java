package com.hibernate.dao;

import com.hibernate.pojo.Order;

public interface OrderDao {
	Order readOrder(String orderName);
	Order readAvailableity();

}
