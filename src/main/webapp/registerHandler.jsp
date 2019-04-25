<%@ page import="JavaBean.Usr" %>
<%@ page import="JavaDao.RegisterDao" %><%--
  Created by IntelliJ IDEA.
  User: zhouzhipeng
  Date: 2019-04-18
  Time: 08:14
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
    <title>registerHandler</title>
</head>
<body>
    <jsp:useBean id="user" class="JavaBean.Usr" scope="session">
    </jsp:useBean>
    <jsp:setProperty name="user" property="*"/>
    <%
        RegisterDao registerDao = new RegisterDao();
        registerDao.register(user);
        if(registerDao.register(user) == 1){
            out.println("用户注册成功，用户信息已经保存在会话session中。<br>下面显示信息取自内置对象session:<br>");
            Usr p = (Usr)session.getAttribute("user");
            out.println("该用户名或者邮箱已经被注册！");
            out.println("用户名: " + p.getUsername() + "Email: " + p.getEmail());

        }else {
            out.println("用户注册失败，请重新注册！");
        }
    %>
</body>
</html>
