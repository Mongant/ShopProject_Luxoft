<%@ page import="com.gorbunov.utils.GenerateId" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client menu</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <%GenerateId.generateId();%>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Client menu</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="clientDoShoppingOptions.jsp"><b>Shopping</b></a></td></tr>
        <tr>
            <td><a href="clientSettings.jsp"><b>Client settings</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</body>
</html>