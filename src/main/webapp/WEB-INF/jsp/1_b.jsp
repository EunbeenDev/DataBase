<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>학생 목록</title>
</head>
<body>
<h1>학생 목록</h1>
<table width="500" border="1">
    <tr>
        <th width="200">학번</th>
        <th width="200">지도교수 번호</th>
        <th width="200">학생 이름</th>
        <th width="200">학년</th>
        <th width="200">전공</th>
    </tr>
    <c:forEach items="${allStudents}" var="student">
        <tr>
            <td>${student[0]}</td>
            <td>${student[1]}</td>
            <td><a href="/1_b/${student[2]}">${student[2]}</a></td>
            <td>${student[3]}</td>
            <td>${student[4]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

