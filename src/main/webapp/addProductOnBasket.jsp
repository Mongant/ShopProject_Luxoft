<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add product on backet</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <jsp:include page="/product" />
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Add product on basket</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/product_container" method="post">
                    <b>ID</b><div><input type="text" name="productId"></div><br>
                    <input type="submit" value="Add product on basket"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>
