<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>과목별 평균과 학점별 학생 수</title>
</head>
<body>
<c:forEach items="${avgExams}" var="avgExam">
    <h1>강좌명: ${avgExam[0]}</h1>
    <h2>총 평균: ${avgExam[1]}</h2>

    <table width="500" border="1">
        <tr>
            <td width="100">학점</td>
            <td width="100">학생 수</td>
        </tr>
        <c:forEach items="${gradeCnts}" var="gradeCnt">
            <tr>
                <td width="100">${gradeCnt[1]}</td>
                <td width="100">${gradeCnt[2]}</td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>
</body>
</html>