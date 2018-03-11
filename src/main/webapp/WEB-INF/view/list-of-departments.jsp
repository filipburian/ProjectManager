<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>

<head>
<title>List of Departments</title>
<meta charset="utf-8"> 
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

	<div class=container-fluid>
		<div>
			<h2>List of Departments</h2>
		</div>

	

		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Department name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- loop over and print our customers -->
				<c:forEach var="tempDepartment" items="${departments}">
				<tr>	
					
						<td>${tempDepartment.id}</td>
					
						<td>${tempDepartment.departmentName}</td>
					<c:url var="departmentInfo"
						value="/departments/department/${tempDepartment.id}" />
					<td><a href="${departmentInfo}">More information</a></td>
				</tr>
				</c:forEach>
			<tbody>
		</table>
		<br>
	<a href="/employee_manager/">Home</a>

	</div>

</body>

</html>