<html>
<head>

</head>
<body>

<#if results??>
    <ul>
        <#--<#list results as keyItem,valItem>
            <li> Skill ${valItem} added ${keyItem} people
            </li>
        </#list>-->
        <#list results as result>
            <li>
                Skill ${result.name} added ${result.cnt} people
            </li>
        </#list>
    </ul>
</#if>
</body>
</html>