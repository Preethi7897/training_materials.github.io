package org.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cts.claims.dao.AuthenticationDaoImpl;
import org.cts.claims.dao.Authentication_Dao;
import org.cts.claims.model.Authentication;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Authentication_Dao dao=new AuthenticationDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("userId");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("role");
		Authentication user=new Authentication(uname, pwd, role);
		String msg=dao.insertUser(user);
		pw.println("<script>alert(msg);</script>");
		response.sendRedirect("admin.jsp");
	}
}
