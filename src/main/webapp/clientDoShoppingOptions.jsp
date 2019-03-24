<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Shopping</title>
    <link type="text/css" rel="stylesheet" href="/style/tableStyle.css"/>
</head>
<body>
    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Shopping</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><a href="/product"><b>Show all products</b></a></td></tr>
        <tr>
            <td><a href="addProductOnBasket.jsp"><b>Add product on basket</b></a></td></tr>
        <tr>
            <td><a href="deleteProductOnBasket.jsp"><b>Remove product on basket</b></a></td></tr>
        <tr>
            <td><a href="/product_container"><b>Show products on basket</b></a></td></tr>
        <tr>
            <td><a href="adminOrderOptions.jsp"><b>Buy (Show order)</b></a></td></tr>
        <tr>
            <td><button type="button" name="back" onclick="history.back()">Back</button></td></tr>
        </tbody>
    </table>
</body>
</html>
