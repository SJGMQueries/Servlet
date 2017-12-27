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

public class LoginSrv extends HttpServlet {

	Connection con;
	PreparedStatement ps;

	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "dugu");
			ps = con.prepareStatement("select PASSWORD,from login_table where USERNAME =?");

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
		PrintWriter pw = resp.getWriter();
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");
		try {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pw.print("<br><font color='green'><b>Employee password=</b></font>"
						+ rs.getString(2));
				if (rs.getString(2).equals(password)) {
					pw.print("Login Successfully");
				}
			} else {
				pw.print("<br>InValid transaction try it again");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);

	}

	public void destroy() {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
