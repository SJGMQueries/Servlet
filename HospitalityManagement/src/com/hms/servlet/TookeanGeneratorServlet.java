package com.hms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.HospitalityManagementDao;
import com.hms.dao.HospitalityManagementDaoFactory;
import com.hms.util.TookeanGenerator;

public class TookeanGeneratorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6420159378737390899L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String doctorName = req.getParameter("dn");

		HospitalityManagementDao dao = HospitalityManagementDaoFactory
				.getInstance();
		pw.print("<body bgcolor='lavender'>");
		String response = dao.getStatus(doctorName);
		if (response == null) {
			pw.print("<h1>Soory Some Technical Issue Cosult With Techinal Team..</h1>");

		} else {
			if (response.equalsIgnoreCase("active")) {
				pw.print("<h1><font color='red'>Responce is: " + response
						+ " Just wait 1min For Tookean No..</font></h1>");

				int tokenNo = TookeanGenerator.generateToken(100);
				pw.print("<h1><font color='blue' size='5'>Collect Your Token: ,Your Token No is : "
						+ tokenNo + "</font></h1>");

			} else {
				pw.print("Soory Docter.: " + doctorName
						+ " Is Not Available Consult with other..");
			}
			pw.print("</body>");
			RequestDispatcher rd = req.getRequestDispatcher("checkReport.html");
			rd.include(req, resp);
		}
	}
}
