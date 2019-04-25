<%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-04-18
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>register</title>
</head>
<body>
    <center>
        <h1>注册页面</h1>
        <form action="registerHandler.jsp" method="post">
            用户名:<input type="text" name="username"/><br>
            密码:<input type="password" name="password"/><br>
            城市:<input type="text" name="city"/><br>
            邮箱:<input type="text" name="email"/><br>
            <input type="submit" value="注册"/>
        </form>
    </center>
</body>
</html>
