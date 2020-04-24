<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>상품번호</td>
				<td>상품명</td>
				<td>가격</td>
			</tr>
			<tr>
				<td>${selectItem.itemNo}</td>
				<td>${selectItem.itemName}</td>
				<td>${selectItem.itemPrice}원</td>
			</tr>
			<tr>
				<td colspan="3">
					<img src="images/home/product${selectItem.itemNo}.jpg" alt="" />	
				</td>
			</tr>
			
		</table>
	</body>
</html>