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
		Circle radius : ${getArea.radius}<br>
		Circle's Area : ${getArea.circleArea()}
		<hr> 
		width : ${getArea.width}<br>
		height : ${getArea.height} <br>
		Rectangle's Area : ${getArea.recArea()}
	</body>
</html>