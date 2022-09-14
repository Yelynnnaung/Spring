<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<a href="new">Create New Contact</a><br> <br>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${contactList }" var="contact" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${contact.name }</td>
					<td>${contact.email }</td>
					<td>${contact.address }</td>
					<td>${contact.phone }</td>
					<td><a href="edit/${contact.id }">Edit</a>&nbsp;&nbsp;
						<a href="delete/${contact.id }" onclick="return confirm('Are you sure you want to delete?')" >Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>