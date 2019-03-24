<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New client</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Create new client</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/client" method="post">
                    <b>Name</b><div><input type="text" name="name"/></div><br>
                    <b>Surname</b><div><input type="text" name="surname"/></div><br>
                    <b>Age</b><div><input type="text" name="age"/></div><br>
                    <b>Phone</b><div><input type="text" name="phone"/></div><br>
                    <b>Email</b><div><input type="text" name="email"/></div><br>
                    <input type="submit" value="Create client"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>