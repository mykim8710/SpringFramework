<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<%String context = request.getContextPath(); %>
		<%=context%>
		
		<form action="<%=context%>/studentView" method="post">
			이름 : <input type="text" name="name"><br>
			나이: <input type="text" name="age"><br>
			학년: <input type="text" name="gradeNum"><br>
			반: <input type="text" name="classNum"><br>

			<input type="submit" value="SUBMIT">	
		</form>
	
	</body>
</html>
