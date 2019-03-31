<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product container list</title>
</head>
<body>
    <h1>Product container list</h1>
    <table border="1">
        <tr>
            <th>Product container</th>
        </tr>
            <tr>
                <td>${productContainer.productsContainer.entrySet()}</td>
            </tr>
    </table>
</body>
</html>
