package com.servlet.switchString;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillSrv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		// Data Retraive from page
		double quantity = 0;
		double price_per_one = 0;
		double price = 0;
		String doctor_Name = req.getParameter("pdr");
		String patient_Name = req.getParameter("pname");
		String medicine_name = req.getParameter("mname1");
		quantity = Double.parseDouble(req.getParameter("qty1"));
		String date = req.getParameter("date");
		switch (medicine_name) {
		case "dola650":
			price_per_one = 6;
			price = quantity * price_per_one;
			break;
		case "flexon":
			price_per_one = 1;
			price = quantity * price_per_one;
			break;
		case "sinarest":
			price_per_one = 2.50;
			price = quantity * price_per_one;
			break;
		case "thyroxin":
			price_per_one = 10;
			price = quantity * price_per_one;
			break;
		case "nice":
			price_per_one = 4;
			price = quantity * price_per_one;
			break;
		}
		// pw.print("price:-" + price);

		pw.print("<body bgcolor='lavender'>");
		pw.print("<center><h1><font color='red'>"
				+ "System Generated Bill_Details" + "</center></h1></font>");
		pw.print("<form>");
		pw.print("<fieldset>");
		pw.print("<legend>");
		pw.print("<u><b><font color='red'>" + "Medicine Bill"
				+ "</font></u></b>");
		pw.print("</legend>");
		pw.print("Prescribe Doctor's name:" + "\t" + doctor_Name);
		pw.print("<br>");
		pw.print("Patient's Name:" + patient_Name);
		pw.print("<br>");
		pw.print("Medicine Name:" + medicine_name);
		pw.print("<br>");
		pw.print("Quantity:" + quantity);
		pw.print("<br>");
		pw.print("Total Price:-" + price);
		pw.print("<br>");
		pw.print("Bill Date:-" + date);
		pw.print("</form>");
		pw.print("</fieldset>");
		pw.print("</body>");

	}

}
