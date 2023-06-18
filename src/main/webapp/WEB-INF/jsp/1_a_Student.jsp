<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>레코드 출력</title>
	</head>
	<body>
		<h1>총 tuple 수: ${cnt}</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">아이디</td>
				<td width="100">지도교수</td>
				<td width="100">이름</td>
				<td width="100">학년</td>
				<td width="100">학부</td>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td width="100">${student.getSno()}</td>
					<td width="100">${student.getPno()}</td>
					<td width="100">${student.getSname()}</td>
					<td width="100">${student.getYear()}</td>
					<td width="100">${student.getDept()}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>


