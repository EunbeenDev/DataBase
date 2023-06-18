<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>도서 정보 삽입</title>
</head>
<body>
<h1>도서 정보 삽입</h1>

<form action="/2_d" method="post">
    <h2>Book 정보</h2>
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" required><br>

    <label for="title">책 제목:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="year">출판 연도:</label>
    <input type="text" id="year" name="year" required><br>

    <label for="price">가격:</label>
    <input type="text" id="price" name="price" required><br>

    <h2>Author 정보</h2>
    <label for="authorName">작가 이름:</label>
    <input type="text" id="authorName" name="authorName" required><br>

    <label for="authorAddress">작가 주소:</label>
    <input type="text" id="authorAddress" name="authorAddress" required><br>

    <label for="authorUrl">URL:</label>
    <input type="text" id="authorUrl" name="authorUrl" required><br>

    <h2>Written By 정보</h2>
    <label for="writtenByName">작가 이름:</label>
    <input type="text" id="writtenByName" name="writtenByName" required><br>

    <label for="writtenByAddress">작가 주소:</label>
    <input type="text" id="writtenByAddress" name="writtenByAddress" required><br>

    <label for="writtenByIsbn">ISBN:</label>
    <input type="text" id="writtenByIsbn" name="writtenByIsbn" required><br>

    <h2>Stocks 정보</h2>
    <label for="stocksIsbn">ISBN:</label>
    <input type="text" id="stocksIsbn" name="stocksIsbn" required><br>

    <label for="stocksCode">창고 코드:</label>
    <input type="text" id="stocksCode" name="stocksCode" required><br>

    <label for="stocksNum">재고 수량:</label>
    <input type="text" id="stocksNum" name="stocksNum" required><br>

    <h2>Published By 정보</h2>
    <label for="publishedByName">출판사 이름:</label>
    <input type="text" id="publishedByName" name="publishedByName" required><br>

    <label for="publishedByIsbn">ISBN:</label>
    <input type="text" id="publishedByIsbn" name="publishedByIsbn" required><br>

    <br>
    <button type="submit">삽입</button>
</form>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
