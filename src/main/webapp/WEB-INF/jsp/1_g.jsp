<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>레코드 출력</title>
</head>
<body>
<table width="500" border="1">
    <tr>
        <td width="100">학과명</td>
        <td width="100">강좌 수</td>
    </tr>
    <c:forEach items="${deptCourses}" var="deptCourse">
        <tr>
            <td width="100">${deptCourse[0]}</td>
            <td width="100">${deptCourse[1]}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

