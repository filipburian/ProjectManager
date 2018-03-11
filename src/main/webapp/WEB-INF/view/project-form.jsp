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

	<form:form action="/employee_manager/projects/saveProject" modelAttribute="project" method="POST">
	<form:hidden path="id"/>
	
		Project Name:
		<form:input path="projectName"/>
		<br><br>
		
		Project beginning date:
		<%-- <fmt:formatDate value="${project.beginningDate}" pattern="yyyy/MM/dd" /> --%>
		<form:input path="beginningDate"/>
		<br><br>
		
		Project end date:
		<%-- <fmt:formatDate value="${project.endDate}" pattern="yyyy/MM/dd" /> --%>
		<form:input path="endDate"/>
		<br><br>
		
		Department:
  					
  		<form:select path="department">
   				<form:options items="${departments}" itemValue="id" itemLabel="departmentName"/>

  		</form:select>
  		<br><br>				
	
		
		Additional information:
		<br><br>
		<form:textarea path="info" rows="5" cols="30" />
		<br><br>
		
		<input type="submit" value="Save" />
			
	
	</form:form>
	
	<br>
	<a href="/employee_manager/">Home</a>
</div>
</body>
</html>