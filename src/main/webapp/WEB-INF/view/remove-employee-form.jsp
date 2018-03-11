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
		<h2>Remove Employee from Project</h2>
		<div class="row">
			<form:form cssClass="form-horizontal"
				action="/employee_manager/projects/project/${id}/removeEmployee"
				modelAttribute="collectionWrapper" method="POST">

			

					<form:select multiple="true" path="employees" size="3" >
						<form:options items="${projectEmployees}" itemValue="id" itemLabel="lastName"/>
					</form:select>


					<br> <br> <input type="submit" value="Remove" />
		
			</form:form>

				<br> <a href="/employee_manager/">Home</a>
		</div>
	</div>
</body>

</html>