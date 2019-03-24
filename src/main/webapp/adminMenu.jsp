<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin menu</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Administration menu</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="adminClientOptions.jsp"><b>Client options</b></a></td></tr>
        <tr>
            <td><a href="adminProductOptions.jsp"><b>Product options</b></a></td></tr>
        <tr>
            <td><a href="adminOrderOptions.jsp"><b>Order options</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</body>
</html>
