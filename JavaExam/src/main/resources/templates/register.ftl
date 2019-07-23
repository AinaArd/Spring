<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Зарегистрируйтесь!
    </div>
    <form method="post">
        <label for="first-name">Email
            <input class="input-field"  id="email" name="email">
        </label>
        <br>
        <label for="last-name">Фамилия
            <input class="input-field"  id="surname" name="surname">
        </label>
        <br>

        <label for="skill_1">Навык
            <input type="text" name="skill1" id="skill1">
        </label>
        <br>
        <label for="skill_2">Навык
            <input type="text" name="skill2" id="skill2">
        </label>
        <br>
        <label for="skill_3">Навык
            <input type="text" name="skill3" id="skill3">
        </label>
        <br>
        <label for="skill_4">Навык
            <input type="text" name="skill4" id="skill4">
        </label>
        <br>
        <label for="skill_5">Навык
            <input type="text" name="skill5" id="skill5">
        </label>
        <br>


        <input type="submit" value="SignUp">
        <br>
    </form>

    <br>
    <br>
    <br>

    <form action="/search">
        <input class="button" type="submit" value="Search">
    </form>


    <br>
    <br>
    <br>

    <form action="/statistics">
        <input class="button" type="submit" value="Statistics">
    </form>

</div>
</body>
</html>