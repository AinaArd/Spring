<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Search
    </div>
    <form method="post">

        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>

        <label for="price">Price
            <input class="input-field" type="text" id="price" name="price">
        </label>

        <label for="manufacturer">Manufacturer
            <input class="input-field" type="text" id="manufacturer" name="manufacturer">
        </label>

        <label for="sale">
            <input type="checkbox" id="sale" name="checkbox" value="Sale">Sale
        </label><br>

        <input type="submit" value="Ok">

    </form>
</div>

</body>
</html>
