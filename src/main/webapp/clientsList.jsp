<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client list</title>
</head>
<body>
<center><h1>Client list</h1></center>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${clientList}" var="clients">
    <tr>
        <td>${clients.id}</td>
        <td>${clients.name}</td>
        <td>${clients.surname}</td>
        <td>${clients.age}</td>
        <td>${clients.phone}</td>
        <td>${clients.email}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
