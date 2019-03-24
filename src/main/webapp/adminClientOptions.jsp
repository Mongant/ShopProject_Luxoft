<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client options</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Client options</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="addNewClient.jsp"><b>Add new client</b></a></td></tr>
        <tr>
            <td><a href="updateClient.jsp"><b>Update client information</b></a></td></tr>
        <tr>
            <td><a href="deleteClient.jsp"><b>Delete client</b></a></td></tr>
        <tr>
            <td><a href="/client"><b>Show clients list</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</body>
</html>
