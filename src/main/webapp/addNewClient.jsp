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
                <form action="/clients" method="post">
                    Name......<input type="text" name="name"/><br>
                    Surname.<input type="text" name="surname"/><br>
                    Age........<input type="text" name="age"/><br>
                    Phone.....<input type="text" name="phone"/><br>
                    Email.....<input type="text" name="email"/><br><br>
                    <input type="submit" value="Create client"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>