<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/3/2021
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<a href="/products?action=create">Create new product</a>
<h1>Danh sách sản phẩm</h1>
<table>
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
<c:forEach items="${products}" var="product">
    <tr>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
