<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h3>Post방식 전송</h3>
		<form action="student" method="post">
			id : <input type="text" name="id"><br>
			pw : <input type="password" name="pw"><br><br>
			<input type="submit" value="SUBMIT">	
		</form>
		<hr>
		<h3>Get방식 전송</h3>
		<form action="student" method="get">
			id : <input type="text" name="id"><br>
			pw : <input type="password" name="pw"><br><br>
			<input type="submit" value="SUBMIT">	
		</form>
	</body>
</html>
