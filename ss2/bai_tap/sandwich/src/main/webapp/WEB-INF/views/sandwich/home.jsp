<%--
  Created by IntelliJ IDEA.
  User: nguyenkimquockhanh
  Date: 28/11/25
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>Sandwich Condiments</label>
<form action="${pageContext.request.contextPath}/save" method="post">
    <input type="checkbox" name="condiments" value="mayonnaise">Mayonnaise<br>
    <input type="checkbox" name="condiments" value="lettuce">Lettuce<br>
    <input type="checkbox" name="condiments" value="tomato">Tomato<br>
    <input type="checkbox" name="condiments" value="mustard">Mustard<br>
    <input type="checkbox" name="condiments" value="sprouts">Sprouts<br>
    <input type="submit" value="Submit">
</form>
<c:choose>
    <c:when test="${not empty condimentList}">
        <h2>Selected condiments:</h2>
        <ul>
            <c:forEach var="item" items="${condimentList}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <h2>No condiments selected.</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
