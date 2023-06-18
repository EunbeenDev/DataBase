<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Saled Books</title>
</head>
<body>
<h1>Saled Books</h1>
<table>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
        <th>Year</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="book" items="${saledBooks}">
        <tr>
            <td>${book[0]}</td>
            <td>${book[1]}</td>
            <td>${book[2]}</td>
            <td>${book[3]}</td>
            <td>${book[4]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
