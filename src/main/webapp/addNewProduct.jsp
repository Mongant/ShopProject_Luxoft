<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New product</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
    <style>
        .wrap {
            width: 150px;
            background: #fff8ba;
            height: 10px;
        }
    </style>
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
                <form action="/products" method="post">
                    <b>Product name</b><div class="wrap"><input type="text" name="productName"/></div><br>
                    <b>Description</b><div class="wrap"><input type="text" name="description"/></div><br>
                    <b>Price</b><div class="wrap"><input type="text" name="price"/></div><br>
                    <input type="submit" value="Create product"/>
                </form></td></tr>
        </tbody>
    </table>
</body>
</html>
