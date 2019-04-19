<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        ${participant.name}
    </div>
    <table>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.text}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
