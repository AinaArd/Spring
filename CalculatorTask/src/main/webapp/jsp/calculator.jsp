<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Calculator</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Calculator
    </div>
    <form method="post">
        <label for="first_digit">First digit
            <input class="input-field" type="number" id="first_digit" name="first_digit">
        </label>

        <label for="sign">Sign
            <input class="input-field" type="text" id="sign" name="sign">
        </label>

        <label for="second_digit">Second digit
            <input class="input-field" type="number" id="second_digit" name="second_digit">
        </label>

        <input type="submit" value="Calculate">
    </form>
</div>

${result}

</body>
</html>