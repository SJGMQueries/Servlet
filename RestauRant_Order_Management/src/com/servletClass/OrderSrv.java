package com.servletClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.OrderDao;
import com.hibernate.dao.OrderDaoFactory;
import com.hibernate.pojo.Order;

public class OrderSrv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String order_Item = req.getParameter("iname");
		OrderDao dao = OrderDaoFactory.getInstance();
		Order item = dao.readOrder(order_Item);

		if (item == null) {
			pw.print("Sorry No Order Available in our restaurant");
		}
		String status_Details=item.getStatus();
		if (status_Details.equalsIgnoreCase("not available")) {
			Order status = dao.readAvailableity();
			pw.print("Sry ur current item is not available but alternative is..");
			pw.print(status);
		} else {
			pw.print(item);
		}
	}

}
