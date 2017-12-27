package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BputSrv extends HttpServlet{
	
	Connection con;
	PreparedStatement ps;
	public void init(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dugu");
			ps=con.prepareStatement("select * from STUDENT_RECORD where regdNo=?");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		int no=Integer.parseInt(req.getParameter("no"));
		//String name=req.getParameter("name");
		
		try {
			ps.setInt(1,no);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.print("<body bgcolor='lavender'>");
				pw.print("<h1><center><font color='green'><u>Software Exam Results-2015</u></font></center></h1>");
				pw.print("<br><font color='dark blue'><b>RegdNo =</b></font>"+rs.getInt(1));
				pw.print("<br><font color='dark blue'><b>Name of Student=</b></font>"+rs.getString(8));
				pw.print("<br><font color='dark blue'><b>Core java=</b></font>"+rs.getDouble(3));
				pw.print("<br><font color='dark blue'><b>Advance java=</b></font>"+rs.getDouble(4));
				pw.print("<br><font color='dark blue'><b>Hibernate=</b></font>"+rs.getDouble(5));
				pw.print("<br><font color='dark blue'><b>Spring=</b></font>"+rs.getDouble(6));
				pw.print("<br><font color='dark blue'><b>WebServices=</b></font>"+rs.getDouble(7));
				pw.print("<br><font color='dark blue'><b>Grade Score=</b></font>"+rs.getString(2));
				pw.print("</body>");
			}
			else{
				pw.print("<body bgcolor='lime'>");
				pw.print("<br><b><font color='red'>No record found</font></b>");
				pw.print("</body>");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	
	}
	public void destroy(){
	try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
