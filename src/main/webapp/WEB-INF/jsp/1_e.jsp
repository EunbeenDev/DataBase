<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>학생별 총 이수 학점과 평균 시험 점수</title>
</head>
<body>
<h1>학생별 총 이수 학점과 평균 시험 점수</h1>
<table width="500" border="1">
    <tr>
        <th width="200">학생 이름</th>
        <th width="200">총 이수 학점</th>
        <th width="200">평균 시험 점수</th>
    </tr>
    <c:forEach items="${totCours}" var="info">
        <tr>
            <td width="200">${info[0]}</td>
            <td width="200">${info[1]}</td>
            <td width="200">${info[2]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
