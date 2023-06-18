<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>전체 작가 목록</title>
</head>
<body>
<h1>전체 작가 목록</h1>
<table width="500" border="1">
    <tr>
        <th width="200">작가 이름</th>
    </tr>
    <c:forEach items="${allAuthors}" var="author">
        <tr>
            <td width="200"><a href="/2_a/${author[0]}">${author[0]}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>