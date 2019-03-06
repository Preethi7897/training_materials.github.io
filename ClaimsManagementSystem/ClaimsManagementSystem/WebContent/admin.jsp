<%@include file="/includes/header.jsp"%>
<%@include file="/includes/adminnavbar.jsp"%>
<%
	Boolean param=Boolean.parseBoolean(request.getParameter("search"));
	//out.println(param);
	Boolean search=param?true:false;
	//search=(Boolean)request.getAttribute("search");
	if(search)
	{
	
%>
<div class="container mt-5">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Search Claims</div>
				<div class="card-body">
				<form action="./searchClaim">
					<div class="form-group">
						<label class="col-form-label">Claim Id</label>
						<input type="text" id="id" name="id" class="form-control">
					</div>
					<input type="submit" value="Submit">
				</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<%
	}
%>
<%
	Boolean add=Boolean.parseBoolean(request.getParameter("addUser"));
	//out.println(param);
	Boolean addUser=add?true:false;
	//search=(Boolean)request.getAttribute("search");
	if(addUser)
	{
	
%>
<div class="container mt-5">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Add User</div>
				<div class="card-body">
				<form action="./addUser" method="post">
					<div class="form-group">
						<label class="col-form-label">UserId</label>
						<input type="text" id="userId" name="userId" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Password</label>
						<input type="password" id="pwd" name="pwd" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">confirm password</label>
						<input type="text" id="confirm" name="confirm" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">User Role</label>
						<select class="form-control" name="role" id="role">
							<option value="CSR">CSR</option>
							<option value="admin">Admin</option>
							<option value="adjuster">Adjuster</option>
						</select>
					</div>
					<input type="submit" class="btn-primary" value="Submit">
					<input type="reset" class="btn-primary" value="Reset">
				</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<%
	}
%>

<%
	Boolean addp=Boolean.parseBoolean(request.getParameter("addPolicy"));
	//out.println(param);
	Boolean addPolicy=addp?true:false;
	//search=(Boolean)request.getAttribute("search");
	if(addPolicy)
	{
	
%>
<div class="container mt-5">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Add Policies</div>
				<div class="card-body">
				<form action="./addPolicy" method="post">
					<div class="form-group">
						<label class="col-form-label">Policy id</label>
						<input type="text" id="pid" name="pid" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Policy Start Date</label>
						<input type="date" id="sdate" name="sdate" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Coverage Amount</label>
						<input type="number" id="amt" name="amt" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Policy Status</label>
						<input type="text" id="status" name="status" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Policy Term</label>
						<input type="text" id="term" name="term" class="form-control">
					</div>
					<input type="submit" class="btn btn-danger" value="Submit">
					<input type="reset" class="btn btn-primary" value="Reset">
				</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<%
	}
%>
<%
	Boolean adda=Boolean.parseBoolean(request.getParameter("addAdjuster"));
	//out.println(param);
	Boolean addAdjuster=adda?true:false;
	//search=(Boolean)request.getAttribute("search");
	if(addAdjuster)
	{
	
%>
<div class="container mt-5">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Add Adjuster</div>
				<div class="card-body">
				<form action="./addAdjuster" method="post">
					<div class="form-group">
						<label class="col-form-label">Adjuster Id</label>
						<input type="text" id="adjusterId" name="adjusterId" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Claim Type</label>
						<input type="text" id="claimType" name="claimType" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">First Name</label>
						<input type="text" id="fname" name="fname" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Last Name</label>
						<input type="text" id="lname" name="lname" class="form-control">
					</div>
					<div class="form-group">
						<label class="col-form-label">Experience</label>
						<input type="text" id="exp" name="exp" class="form-control">
					</div>
					<input type="submit" class="btn btn-danger" value="Submit">
					<input type="reset" class="btn btn-primary" value="Reset">
				</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<%
	}
%>

<%@include file="/includes/footer.jsp"%>