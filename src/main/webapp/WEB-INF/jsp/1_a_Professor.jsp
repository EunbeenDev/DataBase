<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>레코드 출력</title>
</head>
<body>
<h1>총 tuple 수: ${cnt}</h1>
<table width="500" border="1">
    <tr>
        <td width="100">교수번호</td>
        <td width="100">이름</td>
        <td width="100">전공</td>
        <td width="100">부서</td>
    </tr>
    <c:forEach items="${professors}" var="professors">
        <tr>
            <td width="100">${professors.getPno()}</td>
            <td width="100">${professors.getPname()}</td>
            <td width="100">${professors.getPmajor()}</td>
            <td width="100">${professors.getPdept()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


