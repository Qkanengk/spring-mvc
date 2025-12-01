<%--
  Created by IntelliJ IDEA.
  User: nguyenkimquockhanh
  Date: 1/12/25
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/setting/save" method="post" modelAttribute="setting">
    Languages: <form:select path="language">
    <form:option value="English">English</form:option>
    <form:option value="Vietnamese">Vietnamese</form:option>
    <form:option value="Japanese">Japanese</form:option>
    <form:option value="Chinese">Chinese</form:option>
</form:select><br>
    Page size:<form:select path="pageSize" >
    <form:option value="10">10</form:option>
    <form:option value="20">20</form:option>
    <form:option value="30">30</form:option>
</form:select><br>
    Spam filter:<form:checkbox path="spamFilter" ></form:checkbox><br>
    Signature: <form:textarea path="signature"></form:textarea>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
