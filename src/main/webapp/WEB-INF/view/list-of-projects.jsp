<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>

<head>
<title>List of Projects</title>
<meta charset="utf-8"> 
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class=container-fluid>

		<div>
			<h2>List of Projects</h2>
		</div>

		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Project name</th>
					<th>Department</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempProject" items="${projects}">
				<tr>
					<td>${tempProject.id}</td>
		
					<td>${tempProject.projectName}</td>
					
					<c:url var="departmentLink" value="/departments/department/${tempProject.department.id}"/>
							<td><a href="${departmentLink}">${tempProject.department.departmentName}</a></td>
					
					<c:url var="updateLink" value="/projects/project/${tempProject.id}" />
		
					<td><a href="${updateLink}">More information</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
	<a href="/employee_manager/">Home</a>
	</div>

</body>

</html>