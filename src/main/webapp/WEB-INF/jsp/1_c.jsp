<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>이상한 성적</title>
</head>
<body>
<h1>이상한 성적인 학생 목록</h1>
<table width="500" border="1">
    <tr>
        <th width="100">학번</th>
        <th width="100">과목번호</th>
        <th width="100">시험 점수</th>
        <th width="100">성적</th>
        <th width="100">수정</th>
    </tr>
    <c:forEach items="${weireds}" var="weired">
        <tr>
            <td width="100">${weired[0]}</td>
            <td width="100">${weired[1]}</td>
            <td width="100">${weired[2]}</td>
            <td width="100">${weired[3]}</td>
            <td width="100"><a href="/1_c/${weired[0]}">수정</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>