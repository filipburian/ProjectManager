<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<title>Employee Manager Home Page</title>
</head>
<body>
	<section>
		<div>
			<h2>${greeting}</h2>
			<h4>${tagline}</h4>
			
			<a href="employees"> List of employees</a><br><br>
			<a href="employees/employeeForm"> Add employee</a><br><br>
			<a href="departments"> List of departments</a><br><br>
			<a href="departments/showDepartmentForm"> Add department</a><br><br>
			<a href="projects"> List of Projects</a><br><br>
			<a href="projects/showProjectForm"> Add project</a>

		</div>
	</section>
</body>
</html>