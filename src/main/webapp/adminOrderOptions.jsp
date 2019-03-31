<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Order options</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Order options</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="/order"><b>Show all orders</b></a></td></tr>
        <tr>
            <td><a href="deleteOrder.jsp"><b>Delete order</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</body>
</html>
