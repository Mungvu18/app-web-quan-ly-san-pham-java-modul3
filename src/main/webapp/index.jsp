<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product list</title>
  </head>
  <body>
 <h1>Danh sách sản phẩm</h1>
  <table>
    <tr>
      <td>Name</td>
      <td>Price</td>
      <td>Description</td>
    </tr>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
