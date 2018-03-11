<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>

<head>
<title>Project information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="container-fluid">
		<h2>Project ${project.projectName}</h2>



	
		<div>ID: ${project.id}</div>
		<div>Project name: ${project.projectName}</div>
		<div>Begin date: ${project.beginningDate}</div>
		<div>End date: ${project.endDate}</div>
		<div>Info: ${project.info}</div>
		
		<c:url var="departmentLink"
				value="/departments/department/${project.department.id}" />
		
		<div>Department: <a href="${departmentLink}">${project.department.departmentName}</a></div>
		<dl>
		<dt>Employees:</dt>
		<c:forEach var="tempEmployee" items="${project.employees}">

			<c:url var="employeeLink"
				value="/employees/employee/${tempEmployee.id}" />
				
			<dd>
			<div>
				<a href="${employeeLink}">${tempEmployee.firstName}
					${tempEmployee.lastName}</a>
			</div>
			</dd>
		</c:forEach>
		</dl>
		
		<c:url var="editProject" value="${project.id}/updateProject">
			<%-- <c:param name="projectId" value="${project.id}" /> --%>
		</c:url>
		
		<a href="${editProject}">Edit</a><br>

		<c:url var="deleteProject" value="${project.id}/deleteProject">
			<%-- <c:param name="projectId" value="${project.id}" /> --%>
		</c:url>
		<a href="${deleteProject}" onclick="if(!(confirm('Are you sure you want to delete this Project?')))
								 return false;">Delete</a><br>
		
		<c:url var="removeEmployee" value="${project.id}/removeEmployee">
			<%-- <c:param name="projectId" value="${project.id}" /> --%>
		</c:url>
		<br>
		<a href="${removeEmployee}">Remove Employees</a><br>
		
		<a href="/employee_manager/">Home</a>

	</div>

</body>

</html>