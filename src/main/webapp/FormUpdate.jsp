<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
	String username = (String) session.getAttribute("user");
	String password = (String) session.getAttribute("pass");
	int id = (int) session.getAttribute("id");
%>

<div class="container">
	<h1>Update User</h1>
	<div class="card">
	<div class="card-body">
	<form action="update-user-2" method="post">
	  <div class="mb-3">
	    <label for="id" class="form-label">Id</label>
	    <input type="text" class="form-control" id="id" name="id" value="<%=id%>" readonly>
	  </div>
	  <div class="mb-3">
	    <label for="username" class="form-label">Username</label>
	    <input type="text" class="form-control" id="username" name="username" value="<%=username%>">
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">Password</label>
	    <input type="password" class="form-control" id="password" name="password" value="<%=password%>">
	  </div>
	  <button type="submit" class="btn btn-primary">Save</button>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	</form>
	</div>
	</div>
</div>
</body>
</html>