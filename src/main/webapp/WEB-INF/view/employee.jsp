<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>

<head>
<title>Employee information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="container-fluid">
		<div>
			<div>
				<h2>${employee.firstName}${employee.lastName}</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">

				<div>ID: ${employee.id}</div>
				<div>First name: ${employee.firstName}</div>
				<div>Last name: ${employee.lastName}</div>
				<div>Birthday: ${employee.birthday}</div>
				<div>Hire date: ${employee.hireDate}</div>
				<div>E-mail: ${employee.email}</div>
				<div>Role: ${employee.companyRole}</div>
				<div>Experience: ${employee.experience}</div>
				<div>Salary: ${employee.salary}</div>
				<div>Mobile: ${employee.mobilePhone}</div>
				<c:url var="departmentLink"
					value="/departments/department/${employee.department.id}" />

				<div>
					Department: <a href="${departmentLink}">${employee.department.departmentName}</a>
				</div>
				<dl>
					<dt>Projects:</dt>

					<c:forEach var="tempProject" items="${employee.projects}">
						<c:url var="projectLink"
							value="/projects/project/${tempProject.id}" />
						<dd>
							<a href="${projectLink}">${tempProject.projectName}</a>
						</dd>
					</c:forEach>
				</dl>


				<c:url var="editEmployee" value="${employee.id}/updateEmployee">
					<%-- <c:param name="employeeId" value="${employee.id}" /> --%>
					<%-- <c:param name="firstName" value = "${employee.firstName}" /> --%>
				</c:url>


				<a href="${editEmployee}">Edit</a> <br>
				<c:url var="deleteEmployee"
					value="${employee.id}/deleteEmployee">
					<%-- <c:param name="employeeId" value="${employee.id}" /> --%>
				</c:url>
				<a href="${deleteEmployee}"
					onclick="if(!(confirm('Are you sure you want to delete this Employee?')))
								 return false;">Delete</a>
								 
				 <c:url var="addProject" value="${employee.id}/addProject">
					<%-- <c:param name="employeeId" value="${employee.id}" /> --%>
					<%-- <c:param name="firstName" value = "${employee.firstName}" /> --%>
				</c:url>
				<br> 
				<a href="${addProject}">Add Project</a> <br>


			</div>
			<div class="col-sm-4"></div>
		</div>
		<a href="/employee_manager/">Home</a>
	</div>

</body>

</html>