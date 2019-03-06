package org.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cts.claims.dao.UserDao;
import org.cts.claims.dao.UserDaoImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao dao=new UserDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("password");
		String role=dao.validateUser(uname, pwd);
		System.out.println(role);
		if(role.equals("csr"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			request.setAttribute("pageTitle", "Customer Service Excecutive");
			RequestDispatcher rd=request.getRequestDispatcher("csr.jsp");
			rd.forward(request, response);
		}
		else if(role.equals("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			request.setAttribute("pageTitle", "Administrator");
			request.setAttribute("search", false);
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
		else if(role.equals("adjuster"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			request.setAttribute("pageTitle", "Adjuster");
			RequestDispatcher rd=request.getRequestDispatcher("adjuster.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("pageTitle", "Login Page");
			request.setAttribute("msg", "No User Found");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
