<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>

<head>
<title>Department information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="container-fluid">
		<h2>Department: ${department.departmentName}</h2>

		<div class="row">
			<div class="col-sm-4">
				<div>ID: ${department.id}</div>
				<div>Department name: ${department.departmentName}</div>
				<dl>
					<dt>Projects:</dt>
					<c:forEach var="tempProject" items="${department.projects}">

						<c:url var="projectLink"
							value="/projects/project/${tempProject.id}" />

						<dd>
							<div>
								<a href="${projectLink}">${tempProject.projectName}</a>
							</div>
						</dd>
					</c:forEach>

					<dt>Employees:</dt>
					<c:forEach var="tempEmployee" items="${department.employees}">
						<c:url var="employeeLink"
							value="/employees/employee/${tempEmployee.id}" />
						<dd>
							<div>
								<a href="${employeeLink}">${tempEmployee.id}
									${tempEmployee.firstName} ${tempEmployee.lastName}</a>
							</div>
						</dd>
					</c:forEach>
				</dl>
				<c:url var="editDepartment"
					value="/departments/department/updateDepartment">
					<c:param name="departmentId" value="${department.id}" />
				</c:url>
				<a href="${editDepartment}">Edit</a><br>
				<c:url var="deleteDepartment"
					value="/departments/department/deleteDepartment">
					<c:param name="departmentId" value="${department.id}" />
				</c:url>
				<a href="${deleteDepartment}">Delete</a><br>
				
				<a href="/employee_manager/">Home</a>
			</div>
		</div>
	</div>

</body>

</html>