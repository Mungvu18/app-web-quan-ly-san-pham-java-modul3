
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit form</title>
</head>
<body>
<h1>Chỉnh sửa đối tượng</h1>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${product.getName()}" placeholder="input name"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" value="${product.getPrice()}" placeholder="input price"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${product.getDescription()}" placeholder="input description"></td>
        </tr>
        <tr>
            <td><input type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
