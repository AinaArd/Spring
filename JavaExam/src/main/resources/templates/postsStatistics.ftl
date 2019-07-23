<html>
<head>

</head>
<body>

<form method="post"> Sort by likes
    <input type="submit" name="likes" value="Sort">
</form>

<form method="post"> Sort by answers
    <input type="submit" name="answers" value="Sort">
</form>

<div>
    <#if posts??>
        hello
        <ul>
            <#list posts as post>
                <li>
                    Theme: ${post.theme}
                    <br>
                    Message: ${post.text}
                    <br>
                    Date: ${post.date}
                    <br>
                    Likes: ${post.likes}
                    <br>
                    Answers: ${post.answers?size}
                </li>
            </#list>
        </ul>
    </#if>
</div>
</body>
</html>