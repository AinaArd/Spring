<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Participants
    </div>
    <table>
        <c:forEach items="${product}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.manufacturer.name}</td>
            </tr>
        </c:forEach>
    </table>

    <form method="post">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>

        <label for="price">Price
            <input class="input-field" type="text" id="price" name="price">
        </label>

        <label for="sale">Sale
            <input type="checkbox" id= "sale" name="sale" value="sale">
        </label>

        <input type="submit" value="Ok">
    </form>
</div>
</body>
</html>
