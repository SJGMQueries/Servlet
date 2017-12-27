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


public class DbSrv extends HttpServlet{
	
	Connection con;
	PreparedStatement ps;
	public void init(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dugu");
			ps=con.prepareStatement("select id,name,dept,salary from employee where id=?");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		int no=Integer.parseInt(req.getParameter("teno"));
		try {
			ps.setInt(1,no);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				pw.print("<br><font color='red'><b>Employee id=</b></font>"+rs.getInt(1));
				pw.print("<br><font color='green'><b>Employee name=</b></font>"+rs.getString(2));
				pw.print("<br><font color='pink'><b>Employee dept=</b></font>"+rs.getString(3));
				pw.print("<br><font color='orange'><b>Employee salary=</b></font>"+rs.getInt(4));
			}
			else{
				pw.print("<br>No record found");
				
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
