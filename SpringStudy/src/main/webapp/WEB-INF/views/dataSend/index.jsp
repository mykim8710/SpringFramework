<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form action="requestParam" method="get">
			id : <input type="text" name="id"> <br>
			pw : <input type="password" name="pw"> <br>
			<input type="submit" value="SEND">
		</form>
	</body>
</html>