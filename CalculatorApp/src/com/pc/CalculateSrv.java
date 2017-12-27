package com.pc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateSrv extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		int fstNo=Integer.parseInt(req.getParameter("fno"));
		int secNo=Integer.parseInt(req.getParameter("sno"));
		String s1=req.getParameter("c");
		 if(s1.equalsIgnoreCase("+")){
			 pw.println("<br>Result :-"+(fstNo+secNo));
		 }
		 else if(s1.equalsIgnoreCase("*")){
			 pw.println("<br>Result :-"+(fstNo*secNo));
		 }
		 else if(s1.equalsIgnoreCase("/")){
			 pw.println("<br>Result :-"+(fstNo/secNo));
		 }
		
		 }
		
		
		
		
	}


