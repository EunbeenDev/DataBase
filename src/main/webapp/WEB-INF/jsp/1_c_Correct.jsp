<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>정정된 성적</title>
</head>
<body>
<h1>학생 성적 수정</h1>
<form action="/1_c/${sno}" method="post">
    <table width="500" border="1">
        <tr>
            <th width="100">학번</th>
            <th width="100">과목번호</th>
            <th width="100">시험 점수</th>
            <th width="100">성적</th>
        </tr>
        <c:forEach items="${correct}" var="info">
            <tr>
                <td width="100">${info[0]}</td>
                <td width="100">${info[1]}</td>
                <td width="100">${info[2]}</td>
                <td width="100">
                    <input type="text" name="grade" value="${info[3]}">
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="저장">
</form>
</body>
</html>