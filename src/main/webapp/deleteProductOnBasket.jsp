<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete product on basket</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <jsp:include page="/product_container" />
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Delete product</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/product_container" method="delete">
                    <b>ID</b><div><input type="text" name="id"></div><br>
                    <input type="submit" value="Delete product on basket"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>
