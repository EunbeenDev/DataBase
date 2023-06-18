<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>과목별 최저/최고 점수 학생 정보</title>
</head>
<body>
<c:forEach items="${examMaxMins}" var="examMaxMin">
    <h1>강좌번호: ${examMaxMin[0]} 강좌명: ${examMaxMin[1]}</h1>
    <h2>최저점: ${examMaxMin[2]}</h2>
    <h2>최고점: ${examMaxMin[3]}</h2>
    <h3>최저점 학생 정보</h3>
    <table width="500" border="1">
        <tr>
            <td width="100">학번</td>
            <td width="100">학생 이름</td>
            <td width="100">학년</td>
            <td width="100">학과</td>
            <td width="100">지도교수 이름</td>
        </tr>
        <c:forEach items="${examMins}" var="examMin">
            <tr>
                <td>${examMin[0]}</td>
                <td>${examMin[1]}</td>
                <td>${examMin[2]}</td>
                <td>${examMin[3]}</td>
                <td>${examMin[4]}</td>
            </tr>
        </c:forEach>
    </table>
    <h3>최고점 학생 정보</h3>
    <table width="500" border="1">
        <tr>
            <td width="100">학번</td>
            <td width="100">학생 이름</td>
            <td width="100">학년</td>
            <td width="100">학과</td>
            <td width="100">지도교수 이름</td>
        </tr>
        <c:forEach items="${examMaxs}" var="examMax">
            <tr>
                <td>${examMax[0]}</td>
                <td>${examMax[1]}</td>
                <td>${examMax[2]}</td>
                <td>${examMax[3]}</td>
                <td>${examMax[4]}</td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>
</body>
</html>
