<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
---------------------------------2
<script src="js/jquery.min.js"></script>
<script type="application/x-javascript">
    function submitForm(){
//        console.log('ajax方式提交表单')
        var formParam = $("#userForm").serialize()
        $.ajax({
            url: "/jersey/user",
            type:"POST",
            data:formParam,
            contentType: "application/json",
            dataType:"JSON"
        });

    }
</script>
<body>
    <%--<form action="/jersey/user" id="userForm" method="post">--%>
    <form  id="userForm" method="post" >
        <table>
            <tr>userId</tr>
            <tr><input name="userId" id="userId" value="002"></tr>
            <tr>姓名1</tr>
            <tr><input name="userName" id="userName" value="张三"></tr>
            <tr>age</tr>
            <tr><input name="userAge" id="userAge" value="24"></tr>
            <tr><input type="button"  value="提交" onclick="submitForm()"></tr>
        </table>
    </form>

    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="jersey/user">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
</body>
</html>
