<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sale Form</title>
</head>
<body>
<h1>Sale Form</h1>

<form method="post" action="/2_g">
    <label for="quantity">Quantity:</label>
    <input type="text" name="quantity" id="quantity"/><br/>

    <label for="saleRatio">Sale Ratio:</label>
    <input type="text" name="saleRatio" id="saleRatio"/><br/>

    <input type="submit" value="Apply Sale" />
</form>

</body>
</html>

