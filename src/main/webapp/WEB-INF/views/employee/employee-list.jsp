<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
</head>
<body>
	<h1>List Customer:</h1>
	<a th:href="@{/employee-save}">Add Customer</a>
	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>View</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<th:block th:each="employee : ${listEmployee}">
			<tr>
				<td><p th:text="${employee.id}"></p></td>
				<td><p th:text="${employee.name}"></p></td>
				<td><p th:text="${employee.address}"></p></td>
				<td><a th:href="@{/employee-view/} + ${employee.id}">View</a></td>
				<td><a th:href="@{/employee-update/} + ${employee.id}">Edit</a></td>
				<td><a th:href="@{/employeeDelete/} + ${employee.id}">Delete</a></td>
			</tr>
		</th:block>
	</table>

</body>
</html>