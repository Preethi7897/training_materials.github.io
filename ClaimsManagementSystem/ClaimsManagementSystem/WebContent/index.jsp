<%@include file="/includes/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 mt-5">
			<div class="card">
				<div class="card-header">Login Form</div>
				<div class="card-body">
					<div class="container">
						<form action="./login" method="post">
							<fieldset class="form-group">
								<label for="username">UserName</label> <input type="text"
									class="form-control" id="uname" name="uname">
							</fieldset>
							<fieldset class="form-group">
								<label for="password">password</label> <input type="password"
									class="form-control" id="password" name="password">
							</fieldset>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-4"></div>
<%@include file="/includes/footer.jsp"%>