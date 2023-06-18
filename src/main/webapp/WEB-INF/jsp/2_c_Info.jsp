<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>고객 도서 정보</title>
</head>
<body>
<h1>고객 이름: ${customer[0][0]}</h1>
<table width="500" border="1">
    <tr>
        <th width="200">ISBN</th>
        <th width="200">책 제목</th>
        <th width="200">연도</th>
        <th width="200">가격</th>
        <th width="200">출판사명</th>
        <th width="200">출판사 주소</th>
        <th width="200">출판사 전화번호</th>
        <th width="200">출판사 URL</th>
        <th width="200">작가 이름</th>
        <th width="200">작가 주소</th>
        <th width="200">작가 URL</th>
    </tr>
    <c:forEach items="${customer}" var="book">
        <tr>
            <td width="200">${book[1]}</td>
            <td width="200">${book[2]}</td>
            <td width="200">${book[3]}</td>
            <td width="200">${book[4]}</td>
            <td width="200">${book[5]}</td>
            <td width="200">${book[6]}</td>
            <td width="200">${book[7]}</td>
            <td width="200">${book[8]}</td>
            <td width="200">${book[9]}</td>
            <td width="200">${book[10]}</td>
            <td width="200">${book[11]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>