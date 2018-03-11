<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">

	<form:form action="/employee_manager/departments/saveDepartment" modelAttribute="department"
		method="POST">
		<form:hidden path="id" />
				
		Department Name:				
		<form:input path="departmentName" />
		<br>
		<br>

		<input type="submit" value="Save" />

	</form:form>
	<br>
	<a href="/employee_manager/">Home</a>
	</div>
</body>
</html>