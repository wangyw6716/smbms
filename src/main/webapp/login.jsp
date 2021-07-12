<%--
  Created by IntelliJ IDEA.
  User: WYW
  Date: 2021/7/11
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
    <form method="post" action="/servlet/login">
        <input type="text" name="username" >
        <br>
        <input type="password" name="pwd" >
        <br>
        <input type="submit">
    </form>

</body>
</html>
