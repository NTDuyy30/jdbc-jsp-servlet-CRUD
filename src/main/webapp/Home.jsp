<!doctype html>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.UserDAOHandler"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">User list</h1>
		<hr>
		
		<!-- Add button -->
		<div style="margin-bottom: 10px;">
			<a href="form.jsp" class="btn btn-primary">Add User</a>
		</div>
		
		<div class="card">
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Username</th>
							<th scope="col">Password</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${items}" var="x">
						<tr>
							<th scope="row"><c:out value="${x.id}"/></th>
							<td><c:out value="${x.username}"/></td>
							<td><c:out value="${x.password}"/></td>
							<td><a href="load-by-id?id=<c:out value="${x.id}"/>" class="btn btn-outline-info">Edit</a> 
								<a href="delete?id=<c:out value="${x.id}"/>" data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-outline-danger">Delete</a></td>
						</tr>
						 
						<!-- Modal -->
<!-- 						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        ...
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						        <a href="delete?id=<c:out value="${x.id}"/>" type="button" class="btn btn-primary">Delete</a>
						      </div>
						    </div>
						  </div>
						</div> 
-->
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous" />
</body>
</html>