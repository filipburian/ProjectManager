<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>

<head>
	<title>List of Employees</title>
	<meta charset="utf-8"> 
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div>
		<div>
			<h2>List of Employees</h2>
		</div>
	</div>
		<div>
		 	<table class="table table-striped table-bordered table-hover">
		 		<thead>
      				<tr>
      					 <th>ID</th>
       					 <th>First name</th>
        				 <th>Last name</th>
        				 <th>Department</th>
       					 <th>Action</th>
     				 </tr>
   				 </thead>
   				 <tbody>	
   				 				
					<c:forEach var="tempEmployee" items="${employees}">
						<tr>
						    <td>${tempEmployee.id}</td>
							<td>${tempEmployee.firstName}</td>
							<td>${tempEmployee.lastName}</td>
							<c:url var="departmentLink" value="/departments/department/${tempEmployee.department.id}"/>
							<td><a href="${departmentLink}">${tempEmployee.department.departmentName}</a></td>
							<c:url var="updateLink" value="/employees/employee/${tempEmployee.id}"/>
							<td><a href="${updateLink}">More information</a></td>
						<tr>	
					</c:forEach>
					
				<tbody>			
			</table>
			
			<br>
	<a href="/employee_manager/">Home</a>
		</div>
	
</body>

</html>