<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>

<head>
<title>Add Employee</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>

<body>
	<div class="container-fluid">
	<h2>New Employee</h2>
	<div class="row">
		<form:form cssClass="form-horizontal" action="addProject"
			modelAttribute="employee_projects" method="POST">
			<form:hidden path="id"/>

			<div class="col-sm-4">
				

				<form:select path="projectId">
					<form:options items="${projects}" />
				</form:select>

				<br> <input type="submit" value="Save" />
			</div>
		</form:form>
		
		<br>
	<a href="/employee_manager/">Home</a>
	</div>
</div>
</body>

</html>