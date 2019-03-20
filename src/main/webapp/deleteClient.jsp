<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete client</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Delete client</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/delete_client" method="post">
                Id <input type="text" name="id"><br><br>
                <input type="submit" value="Create client"/>
            </form></td></tr>
        </tbody>
    </table>
</body>
</html>
