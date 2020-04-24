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
				<td>DEPTNO_1</td>
				<td>DName</td>
				<td>LOC</td>
			</tr>
			<c:forEach items="${deptEmpJoin.empList}" var="empList">
				<tr>
					<td>${empList.empNo}</td>
					<td>${empList.eName}</td>
					<td>${empList.job}</td>
					<td>${empList.mgr}</td>
					<td>${empList.hireDate}</td>
					<td>${empList.sal}</td>
					<td>${empList.comm}</td>
					<td>${empList.deptNo}</td>
					<td>${deptEmpJoin.deptNo}</td>
					<td>${deptEmpJoin.dName}</td>
					<td>${deptEmpJoin.loc}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
