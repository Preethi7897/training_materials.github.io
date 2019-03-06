package org.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cts.bean.Emp;
import org.cts.services.EmpService;
import org.cts.services.ServiceImpl;


@WebServlet("/display")
public class DisplayController extends HttpServlet {
	EmpService service=new ServiceImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		List<Emp> emps=service.viewDetails();
		pw.println("<table border=1>");
		pw.println("<tr><th>Eno</th><th>name</th><th>Address</th><th>Gender</th></tr>");
		for(Emp e:emps)
		{
			pw.println("<tr><td>"+e.getEno()+"</td><td>"+e.getName()+"</td><td>"+e.getAddress()+"</td><td>"+e.getGender()+"</td></tr>");
		}
		pw.println("</table>");
		response.sendRedirect("https://www.google.com");
		pw.close();
	}
	

}
