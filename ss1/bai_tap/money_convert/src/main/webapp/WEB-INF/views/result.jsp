<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenkimquockhanh
  Date: 27/11/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert/usd-to-vnd" method="get">
    <input type="number" min="0" name="value" placeholder="Enter value">
    <button type="submit">Convert</button>
</form>
<h5>${value} USD =  <span> ${result} VND</span></h5>

</body>
</html>
