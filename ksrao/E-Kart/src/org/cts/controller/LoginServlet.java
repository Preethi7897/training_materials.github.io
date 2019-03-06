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

import org.cts.beans.User;
import org.cts.dao.UserDao;
import org.cts.dao.UserDaoImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao dao=new UserDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		User u=new User();
		u.setUname(uname);
		u.setPwd(pwd);
		if(dao.validateUser(u))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", u.getUname());
			session.setAttribute("role", u.getRole());
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}
	
	

}
