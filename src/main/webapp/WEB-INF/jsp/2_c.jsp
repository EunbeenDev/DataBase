<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>전체 고객 목록</title>
</head>
<body>
<h1>전체 고객 목록</h1>
<table width="500" border="1">
    <tr>
        <th width="200">고객 Email</th>
        <th width="200">고객 이름</th>
        <th width="200">고객 주소</th>
        <th width="200">고객 전화번호</th>
    </tr>
    <c:forEach items="${allCustomers}" var="customer">
        <tr>
            <td>${customer[0]}</td>
            <td width="200"><a href="/2_c/${customer[1]}">${customer[1]}</a></td>
            <td>${customer[2]}</td>
            <td>${customer[3]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>