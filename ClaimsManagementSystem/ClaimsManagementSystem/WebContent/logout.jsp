<%@include file="/includes/header.jsp"%>
<%
	if(session.getAttribute("uname")!=null)
	{
		session.setAttribute("uname", null);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>
<%@include file="/includes/footer.jsp"%>