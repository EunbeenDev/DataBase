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
        <td width="100">학번</td>
        <td width="100">강좌번호</td>
        <td width="100">성적</td>
        <td width="100">시험점수</td>
    </tr>
    <c:forEach items="${enrolls}" var="enroll">
        <tr>
            <td width="100">${enroll.getSno()}</td>
            <td width="100">${enroll.getCno()}</td>
            <td width="100">${enroll.getGrade()}</td>
            <td width="100">${enroll.getExam()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


