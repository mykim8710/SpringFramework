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
		<form action="result" method="post">
			radius : <input type="text" name="radius">
			<hr>
			width : <input type="text" name="width"><br>
			height : <input type="text" name="height">
			<input type="submit" value="전송">
		</form>
		

	</body>
</html>