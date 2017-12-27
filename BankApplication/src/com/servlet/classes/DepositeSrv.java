package com.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.pojo.TransactionDemo;
import com.transaction.dao.TransactionDao;
import com.transaction.dao.TransactionDaoFactory;

public class DepositeSrv extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String accountNumber = req.getParameter("accno");
		String personName = req.getParameter("pname");
		double amount = Double.parseDouble(req.getParameter("amount"));
		int tokenNo = Integer.parseInt(req.getParameter("tno"));

		TransactionDemo deposite = new TransactionDemo();
		deposite.setSerailId(tokenNo);
		deposite.setAccountNo(accountNumber);
		deposite.setPersonName(personName);
		deposite.setAmount(amount);
		TransactionDao dao = TransactionDaoFactory.getInstance();

		dao.save(deposite);
		pw.print("<br><font color='green'>Deposited amount" + amount
				+ " Successfully...</font><br>");
		pw.print("<br>Mr/Mrs.<font color='green'>"
				+ personName
				+ " Your Transaction Is Recorderd In our DataBase For Further...</font><br>");
		pw.print("<br><font color='green'>Thanks and Visit Again.</font><br>");
	}
}
