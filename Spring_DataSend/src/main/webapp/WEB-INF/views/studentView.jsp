<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Student</title>
	</head>
	<body>
		이름 : ${studentInfo.name} <br>
		나이 : ${studentInfo.age} <br>
		학년 : ${studentInfo.gradeNum} <br> 
		반 : ${studentInfo.classNum}
	</body>
</html>
