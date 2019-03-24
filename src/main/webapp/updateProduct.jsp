<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update product</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
<jsp:include page="/product" />
<table class="cinereousTable">
    <thead>
    <tr>
        <th>Update product</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <form action="/product" method="put">
                <b>Id</b><div><input type="text" name="id"/></div><br>
                <b>Product name</b><div><input type="text" name="productName"/></div><br>
                <b>Price</b><div><input type="text" name="price"/></div><br>
                <b>Price</b><div><input type="text" name="price"/></div><br>
                <input type="submit" value="Update product"/>
            </form></td></tr>
    </tbody>
</table>
</body>
</html>
