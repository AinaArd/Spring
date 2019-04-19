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


    <form action="<c:url value="/login"/>">
        <input type="submit" value="Log in by email">
    </form>
    <%--<a href="/login">Log in</a>--%>
</div>
</body>
</html>
