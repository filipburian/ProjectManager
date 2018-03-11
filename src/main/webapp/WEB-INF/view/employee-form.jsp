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
			<form:form cssClass="form-horizontal"
				action="/employee_manager/employees/saveEmployee"
				modelAttribute="employee" method="POST">
				<form:hidden path="id" />

				<div class="col-sm-4">
					<h3>Personal information:</h3>
					First Name:

					<form:input path="firstName" />
					<form:errors path="firstName" cssClass="error" />

					<br> <br> Last Name:
					<form:input path="lastName" />
					<form:errors path="lastName" cssClass="error" />

					<br> <br> Email:
					<form:input path="email" />
					<form:errors path="email" cssClass="error" />

					<br> <br> Birthday:
					<%-- <fmt:formatDate value="${employee.birthday}" pattern="yyyy/MM/dd" /> --%>
					<form:input path="birthday" />

					<br> <br> Mobile phone number:
					<form:input path="mobilePhone" />


				</div>

				<div class="col-sm-4">
					<h3>Company information:</h3>
					Day of Hire:
					<%-- 	<fmt:formatDate value="${employee.hireDate}" pattern="yyyy/MM/dd" /> --%>
					<form:input path="hireDate" />

					<br> <br> Company position:
					<form:select path="companyRole">
						<form:options items="${company_role}" />
					</form:select>
					<br> <br> Professional experience:
					<form:select path="experience">
						<form:options items="${professional_experience}" />
					</form:select>

					<br> <br> Department:

					<form:select path="department">
						<form:option value="" />
						<form:options items="${departments}" itemValue="id"
							itemLabel="departmentName" />
					</form:select>

					<br> <br> Project:

					<form:select multiple="true" path="projects" size="3">
						<form:option value="" />
						<form:options items="${projects}" itemValue="id"
							itemLabel="projectName" />
					</form:select>

					<br> <br> Salary:
					<form:input path="salary" />
				</div>


				<div class="col-sm-4">
					<h3>Address:</h3>

					Country:
					<form:input path="homeAddress.country" />

					<br> <br> City:
					<form:input path="homeAddress.city" />

					<br> <br> Zip code:
					<form:input path="homeAddress.zipCode" />

					<br> <br> Street:
					<form:input path="homeAddress.street" />

					<br> <br> Home number:
					<form:input path="homeAddress.homeNumber" />

					<br> <br> <input type="submit" value="Save" />
				</div>
			</form:form>

				<br> <a href="/employee_manager/">Home</a>
		</div>
	</div>
</body>

</html>