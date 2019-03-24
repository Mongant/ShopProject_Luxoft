<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete product</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
<jsp:include page="/product" />
<table class="cinereousTable">
    <thead>
    <tr>
        <th>Delete product</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <form action="/product" method="delete">
                <b>ID</b><div><input type="text" name="id"></div><br>
                <input type="submit" value="Delete product"/>
            </form></td></tr>
    </tbody>
</table>
</body>
</html>
