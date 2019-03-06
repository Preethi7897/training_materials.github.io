package org.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cts.claims.dao.AdjusterDao;
import org.cts.claims.dao.AdjusterDaoImpl;
import org.cts.claims.model.Adjuster;

/**
 * Servlet implementation class AddAdjusterController
 */
@WebServlet("/addAdjuster")
public class AddAdjusterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		AdjusterDao dao=new AdjusterDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int adjusterId=Integer.parseInt(request.getParameter("adjusterId"));
		String ctype=request.getParameter("claimType");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		int exp=Integer.parseInt(request.getParameter("exp"));
		Adjuster adjuster=new Adjuster(adjusterId, ctype, fname, lname, exp);
		String msg=dao.insertAdjuster(adjuster);
		response.sendRedirect("admin.jsp");
	}

}
