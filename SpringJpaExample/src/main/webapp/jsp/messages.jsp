<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Aina
  Date: 04.04.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        ${userName} has messages:
    </div>

    <table>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>${message.author.name}</td>
                <td>${message.content}</td>
                <td>${message.date}</td>
            </tr>
        </c:forEach>
    </table>

    <p>
    <form method="post">
        <label class="select-field" for="content">Enter message
            <input class="input-field" type="text" id="content" name="content">
        </label>
    </form>
    </p>

</div>

</body>
</html>
