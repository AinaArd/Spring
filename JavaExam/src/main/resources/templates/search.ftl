<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<form method="post">
    <label for="skill">Search for users
        <input type="text" id="skill" name="skill" class="input-field">
    </label>
</form>

<div>
    <#if users??>
        Users
        <br>
        <ul>
            <#list users as result>
                <li>
                    Surname: ${result.surname}
                    Email: ${result.email}
                </li>
            </#list>
        </ul>
    </#if>
</div>

</body>
</html>