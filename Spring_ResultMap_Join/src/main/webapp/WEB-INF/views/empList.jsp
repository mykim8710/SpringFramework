<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>EMPNO</td>
				<td>ENAME</td>
				<td>JOB</td>
				<td>MGR</td>
				<td>HIREDATE</td>
				<td>SAL</td>
				<td>COMM</td>
				<td>DEPTNO</td>
			</tr>
			
			<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.empNo}</td>
				<td>${emp.eName}</td>
				<td>${emp.job}</td>
				<td>${emp.mgr}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.sal}</td>
				<td>${emp.comm}</td>
				<td>${emp.deptNo}</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>