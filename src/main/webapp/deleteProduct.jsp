<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete product</title>
</head>
<body>
<table class="cinereousTable">
    <thead>
    <tr>
        <th>Delete product</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <form action="/delete_product" method="post">
                Id <input type="text" name="id"><br><br>
                <input type="submit" value="Delete product"/>
            </form></td></tr>
    </tbody>
</table>
</body>
</html>
