package com.servlet.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSrv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");

		ServletContext app = getServletContext();

		String path = "/WEB-INF/" + app.getInitParameter("readpropertiesfile");
		String realPath = getServletContext().getRealPath(path);

		FileInputStream fis = new FileInputStream(realPath);
		Properties props = new Properties();
		props.load(fis);
		String pwd_file = props.getProperty(userName);
		if (password.equals(pwd_file)) {
			pw.print("<br><a href='main.html'><u><font color='blue'>Successfully Login now double click on link</font></u></a><br><br>");
		} else {
			pw.print("<br><font color='red'>Sorry Invalid UserName And Password re-try<br>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.include(req, resp);

		}
	}

}
