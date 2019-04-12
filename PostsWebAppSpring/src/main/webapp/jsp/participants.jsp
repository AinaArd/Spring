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
        <c:forEach items="${participants}" var="participant">
            <tr>
                <td>${participant.name}</td>
                <td>${participant.city}</td>
                <td>${participant.email}</td>
            </tr>
        </c:forEach>
    </table>

   <%-- <form method="post">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>

        <label for="city">City
            <input class="input-field" type="text" id="city" name="city">
        </label>

        <label for="email">Email
            <input class="input-field" type="text" id="email" name="email">
        </label>

        <input type="submit" value="Add new">
    </form>--%>
</div>
</body>
</html>
