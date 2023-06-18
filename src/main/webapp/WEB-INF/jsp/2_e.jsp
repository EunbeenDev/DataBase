<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>도서 정보</title>
</head>
<body>
<h1>전체 도서의 평균 가격</h1>
<table border="1">
    <tr>
        <th width="200">평균 가격</th>
    </tr>
    <c:forEach items="${totBookPrices}" var="totBookPrice">
        <tr>
            <td>${totBookPrice[0]}</td>
        </tr>
    </c:forEach>
</table>
<h1>년도별 평균 가격</h1>
<table border="1">
    <tr>
        <th width="100">년도</th>
        <th width="200">평균 가격</th>
    </tr>
    <c:forEach items="${yearBookPrices}" var="yearBookPrice">
        <tr>
            <td>${yearBookPrice[0]}</td>
            <td>${yearBookPrice[1]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>