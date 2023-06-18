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
        <td width="100">강좌번호</td>
        <td width="100">교수번호</td>
        <td width="100">강의시간</td>
        <td width="100">강의실</td>
    </tr>
    <c:forEach items="${lectures}" var="lecture">
        <tr>
            <td width="100">${lecture.getCno()}</td>
            <td width="100">${lecture.getPno()}</td>
            <td width="100">${lecture.getLecTime()}</td>
            <td width="100">${lecture.getRoom()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


