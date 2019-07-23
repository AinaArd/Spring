<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Posts
    </div>
    <ul>
        <#if posts??>
            <#list posts as post>
                <li>
                    <#if post.replyTo??>
                        This is answer to: ${post.replyTo.text}
                    </#if>
                    <br>
                    Theme: ${post.theme}
                    <br>
                    Message: ${post.text}
                    <br>
                    Date: ${post.date}
                    <br>
                    Likes: ${post.likes}
                    <br>
                    <form method="post">
                        <input type="hidden" value="${post.id}" name="id">
                        <input type="submit" name="like" value="Like">
                    </form>
                    <form method="post">
                        <input type="hidden" value="${post.id}" name="id">
                        <label for="text">Text
                            <input type="text" name="text" id="text">
                        </label>
                        <input type="submit" name="answer" value="Answer">
                    </form>
                    <br>
                </li>
            </#list>
        </#if>
    </ul>

    <br>
    <br>

    <form method="post">
        <label for="theme">Theme
            <input type="text" name="theme" id="theme">
        </label>
        <label for="text">Text
            <input type="text" name="text" id="text">
        </label>
        <br>
        <br>
        <input type="submit" value="Send">
    </form>

    <form action="/statistics">
        <input class="button" type="submit" value="Statistics">
    </form>

</div>

</body>
</html>
