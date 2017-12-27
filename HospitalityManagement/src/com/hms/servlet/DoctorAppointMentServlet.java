package com.hms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.Bo.DoctorBO;
import com.hms.dao.HospitalityManagementDao;
import com.hms.dao.HospitalityManagementDaoFactory;

public class DoctorAppointMentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7934633751773072383L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String diseaseName = req.getParameter("dis");
		String name=null;

		HospitalityManagementDao dao = HospitalityManagementDaoFactory
				.getInstance();

		@SuppressWarnings("unchecked")
		List<String> check = dao.conformAppointment(diseaseName);
		Iterator<String> itr = check.iterator();

		pw.print("<body bgcolor='lavender'>");
		pw.print("<table border='20'align='center'width='40%'>");
		pw.print("<caption><h1><font color='red'><b><u>Doctor Availability Report</u></b></h1></font></caption>");
		pw.print("<tr bgcolor='lightgreen'><th>Name:</th><th>Check</th></th></tr>");
		while (itr.hasNext()) {
			 name = itr.next();
			pw.print("<tr bgcolor='pink'><td>" + name + "</td>" + "<td>"
					+ "<a href='checkReport.html'>GetResponse</a>" + "</td>"
					+ "</tr>");

			// here i bind the value to session scope
			// coz i need that value in my next servlet
			
			
/*
			HttpSession session = req.getSession();
			session.setAttribute("value", name);
			RequestDispatcher rd1 = req
					.getRequestDispatcher("/checkReport.html");
			rd1.include(req, resp);*/

		}
		pw.print("</table>");
		pw.print("</body>");
	RequestDispatcher rd = req.getRequestDispatcher("/appointment.html");
		rd.include(req, resp);

	}
}
