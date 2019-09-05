<%--
  Created by IntelliJ IDEA.
  User: wangchong
  Date: 2019/9/4
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginForm</title>
</head>
<body>
    欢迎登陆本系统
    <form action="../ValidateServlet" method="post">
        账号：<input type="text" name="userName"><br>
        密码：<input type="password" name="password"><br>
        验证码：<input type="text" name="code" size="10">
        <img src="validate.jsp" border=0>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
