package org.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cts.claims.dao.PolicyDao;
import org.cts.claims.dao.PolicyDaoImpl;
import org.cts.claims.model.Policy;

/**
 * Servlet implementation class AddPolicyController
 */
@WebServlet("/addPolicy")
public class AddPolicyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PolicyDao dao=new PolicyDaoImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Date d=null;
		int policyId=Integer.parseInt(request.getParameter("pid"));
		String startDate=request.getParameter("sdate");
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			d=format.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double coverageAmt=Double.parseDouble(request.getParameter("amt"));
		String status=request.getParameter("status");
		int policy_term=Integer.parseInt(request.getParameter("term"));
		Policy policy=new Policy(policyId, startDate, coverageAmt, status, policy_term);
		String msg=dao.insertPolicy(policy);
		response.sendRedirect("admin.jsp");
		
		pw.close();
		
	}

}
