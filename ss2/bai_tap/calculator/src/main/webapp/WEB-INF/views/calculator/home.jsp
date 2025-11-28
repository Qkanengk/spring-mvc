<%--
  Created by IntelliJ IDEA.
  User: nguyenkimquockhanh
  Date: 28/11/25
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator/calculate" method="post">
    <input type="text" name="number1" placeholder="Number 1">
    <input type="text" name="number2" placeholder="Number 2">
    <select name="operator" required>
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">x</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="Calculate">
</form>
<h2>${result}</h2>

</body>
</html>
