<%--
  Created by IntelliJ IDEA.
  User: nguyenkimquockhanh
  Date: 27/11/25
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="find" method="get">
    <label for="keyword">Enter keyword:</label>
    <input id="keyword" type="text" name="keyword" placeholder="Enter keyword">
    <button type="submit">Find</button>
</form>
<label for="result">Result:</label>
<h3 id="result">${result}</h3>
</body>
</html>
