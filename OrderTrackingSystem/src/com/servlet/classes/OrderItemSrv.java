package com.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.OrderItem;

public class OrderItemSrv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// general setting..
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		// Retrive data from fst form

		String itemName = req.getParameter("itemname");
		int quantity = Integer.parseInt(req.getParameter("qty"));

		// add validation
		if ((quantity <= 0) || (itemName == null)) {
			pw.print("<br>"
					+ "<font color='red'>sorry ur order can't be trace..try again latter.</font>"
					+ "<br>");
			RequestDispatcher rd = req
					.getRequestDispatcher("/orderdetails.html");
			rd.include(req, resp);

		} else {
			// add retraive data into collection
			OrderItem item = new OrderItem();
			item.setItemName(itemName);
			item.setQuantity(quantity);
			List<OrderItem> storeOrder = new ArrayList<>();
			storeOrder.add(item);
			pw.print(storeOrder);
			System.out.println(storeOrder);
		}

	}

}
