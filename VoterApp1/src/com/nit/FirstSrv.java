package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstSrv extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter();
String name=req.getParameter("n");
int age=Integer.parseInt(req.getParameter("page"));
if(age<=18){
	pw.print("<h1><font color='red'><b><i>sorry,you are not eligible for vote</i></b></font></h1>");

}
else{
	pw.print("<h1><font color='green'><b><i>you are eligible for vote</i></b></font></h1>");
	} 


	}
}