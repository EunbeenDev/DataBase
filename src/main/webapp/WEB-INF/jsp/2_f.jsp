<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>작가 정보</title>
</head>
<body>
<h1>작가 정보</h1>
<table border="1">
    <tr>
        <th width="200">작가 이름</th>
        <th width="100">도서 수</th>
        <th width="100">최고 가격</th>
        <th width="100">최저 가격</th>
        <th width="100">평균 가격</th>
    </tr>
    <c:forEach items="${authInfos}" var="authInfo">
        <tr>
            <td width="200">${authInfo[0]}</td>
            <td width="100">${authInfo[1]}</td>
            <td width="100">${authInfo[2]}</td>
            <td width="100">${authInfo[3]}</td>
            <td width="100">${authInfo[4]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>