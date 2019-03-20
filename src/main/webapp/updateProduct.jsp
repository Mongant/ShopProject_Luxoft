<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update product</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <thead>
    <tr>
        <th>Update product</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <form action="/update_product" method="post">
                <b>Id</b><div class="wrap"><input type="text" name="id"/></div><br>
                <b>Product name</b><div class="wrap"><input type="text" name="productName"/></div><br>
                <b>Price</b><div class="wrap"><input type="text" name="price"/></div><br>
                <b>Price</b><div class="wrap"><input type="text" name="price"/></div><br>
                <input type="submit" value="Update product"/>
            </form></td></tr>
    </tbody>
</body>
</html>
