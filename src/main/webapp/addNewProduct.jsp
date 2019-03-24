<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New product</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Create new product</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <form action="/product" method="post">
                    <b>Product name</b><div><input type="text" name="productName"/></div><br>
                    <b>Description</b><div><input type="text" name="description"/></div><br>
                    <b>Price</b><div><input type="text" name="price"/></div><br>
                    <input type="submit" value="Create product"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>
