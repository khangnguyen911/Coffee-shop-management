<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a th:href="@{/employee-list}">List Employee</a><br />

	<h1>Add new Employee:</h1>
	<form th:action="@{/saveEmployee}" method="POST" th:object="${employee}">
    	Name: <input th:field="*{name}"/> <br/> <br/>
    	Address: <input th:field="*{address}"/> <br/> <br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>