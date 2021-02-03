<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tạo mới một sản phẩm</h1>
<form method="post">
<table>
    <tr>
        <td>Name:</td>
        <td><input type="text" name="name" placeholder="input name"></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><input type="text" name="price" placeholder="input price"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input type="text" name="description" placeholder="description"></td>
    </tr>
    <tr>
        <td><input type="submit" value="create"></td>
    </tr>
</table>
</form>
</body>
</html>
