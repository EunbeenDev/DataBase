<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>학생 정보</title>
</head>
<body>
<h1>학생 이름: ${student[0][0]}</h1>
<table width="500" border="1">
    <tr>
        <th width="200">과목명</th>
        <th width="200">학점</th>
        <th width="200">시험 점수</th>
    </tr>
    <c:forEach items="${student}" var="info">
        <tr>
            <td width="200">${info[1]}</td>
            <td width="200">${info[2]}</td>
            <td width="200">${info[3]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
