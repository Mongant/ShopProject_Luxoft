<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete client</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <jsp:include page="/client" />
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Delete client</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/client" method="post">
                    <b>ID</b><div><input type="text" name="id"></div><br>
                <input type="submit" value="Delete client"/>
            </form></td></tr>
        </tbody>
    </table>
</body>
</html>
