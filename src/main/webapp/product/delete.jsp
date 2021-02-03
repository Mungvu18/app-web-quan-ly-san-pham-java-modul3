<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/3/2021
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xóa đối tượng</title>
</head>
<body>
<h1>Xóa đối tượng</h1>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${product.getName()}" ></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" value="${product.getPrice()}" ></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${product.getDescription()}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="delete"></td>
        </tr>
    </table>
</form>
</body>
</html>
