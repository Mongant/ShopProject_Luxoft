<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete order</title>
</head>
<body>
<jsp:include page="/order"/>
<table class="cinereousTable">
    <thead>
    <tr>
        <th>Delete order</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <form action="/order" method="delete">
                <b>ID</b><div><input type="text" name="id"></div><br>
                <input type="submit" value="Delete order"/>
            </form></td></tr>
    </tbody>
</table>
</body>
</html>
