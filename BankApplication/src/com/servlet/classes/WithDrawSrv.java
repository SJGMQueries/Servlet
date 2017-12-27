package com.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transaction.dao.TransactionDao;
import com.transaction.dao.TransactionDaoFactory;

public class WithDrawSrv extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String accountNumber = req.getParameter("accno");
		String personName = req.getParameter("pname");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		TransactionDao dao = TransactionDaoFactory.getInstance();
		/*double amt = dao.availableAmount(accountNumber);
		double current_money = amt - amount;*/
		dao.updateAmount(amount, accountNumber);
		
		pw.print("<br><font color='green'>Withdraw amount" + amount
				+ " Successfully...</font><br>");
		pw.print("<br>Mr/Mrs.<font color='green'>"
				+ personName
				+ " Your Transaction Is Recorderd In our DataBase For Further...</font><br>");
		pw.print("<br><font color='green'>Thanks and Visit Again.</font><br>");
	}

}
