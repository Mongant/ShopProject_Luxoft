<%--
  Created by IntelliJ IDEA.
  User: mongant
  Date: 23.03.19
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Order</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
<table class="cinereousTable">
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Order options</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="adminClientOptions.jsp"><b>Add products in order</b></a></td></tr>
        <tr>
            <td><a href="adminProductOptions.jsp"><b>Add client in order (make an order)</b></a></td></tr>
        <tr>
            <td><a href="adminOrderOptions.jsp"><b>Show product basket</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</table>
</body>
</html>
