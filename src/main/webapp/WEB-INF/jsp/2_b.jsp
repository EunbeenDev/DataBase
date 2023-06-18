<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>출판사 목록</title>
</head>
<body>
<h1>출판사 목록</h1>
<table width="500" border="1">
    <tr>
        <th width="200">출판사 이름</th>
        <th width="200">주소</th>
        <th width="200">전화번호</th>
        <th width="200">URL</th>
    </tr>
    <c:forEach items="${allPublishers}" var="publisher">
        <tr>
            <td><a href="/2_b/${publisher[0]}">${publisher[0]}</a></td>
            <td>${publisher[1]}</td>
            <td>${publisher[2]}</td>
            <td>${publisher[3]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
