<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create/Update Contact</title>
<script>
function goHome() {
	window.location.href = "/ContactManagerPrj/";
}
</script>
</head>
<body>
	<div align="center">
		<h1>Create/Update Contact</h1>
		<form:form action="/ContactManagerPrj/save" method="POST"
			modelAttribute="contact">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name</td>
					<td><form:input path="name" /><form:errors path="name" style="color:red;"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /><form:errors path="email" style="color:red;"/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" /><form:errors path="address" style="color:red;"/></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" /><form:errors path="phone" style="color:red;"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="Cancel" onclick="goHome();" />&nbsp;&nbsp;<input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>