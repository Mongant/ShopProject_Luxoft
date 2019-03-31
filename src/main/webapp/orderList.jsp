<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order list</title>
</head>
<body>
    <center><h1>Order</h1></center>
    <h2>Order# ${order.id}</h2>
    <h3>Client:</h3>
    <h3>${order.client.name}</h3>
    <h3>${order.client.surname}</h3><hr>
    <h3>Products:</h3>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product description</th>
        </tr>
        <c:forEach items="${order.products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table><hr>
    <h2>Amount: ${order.amount}</h2>
</body>
</html>
