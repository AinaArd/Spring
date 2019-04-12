<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Users
    </div>
    <table>
        <c:forEach items="${usersFromDB}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

    <p>
    <form method="get" action="/users/${userName}">
        <label class="select-field" for="userName">Enter user name
            <input class="input-field" type="text" id="userName" name="userName">
        </label>
    </form>
    </p>
</div>
</body>
</html>
