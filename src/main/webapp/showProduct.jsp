<%@ page import="JavaBean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Ciper
  Date: 2019/5/5
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<center>
    <h1>商品列表</h1>
    <table cellspacing="1" cellpadding="0" width="40%" border="0">
        <tbody>
        <tr bgcolor="#fba661" height="20">
            <td><div align="center">编号</div></td>
            <td><div align="center">名称</div></td>
            <td><div align="center">药品分类</div></td>
            <td><div align="center">价格</div></td>
            <td><div align="center">图片</div></td>
            <td><div align="center">购买</div></td>
        </tr>
        <%
            List<Product> list = (List<Product>)request.getAttribute("allProduct");
            Iterator<Product> it = list.iterator();
            Product p;
            while(it.hasNext()){
                p= it.next();

            assert p != null;%>

        <tr bgcolor="f3f3f3" height="25">
            <td width="10%">
                <div align="center"><%=p.getProductnumber()%></div>
            </td>
            <td width="13%">
                <div align="center"><%=p.getProductname()%></div>
            </td>
            <td width="12%">
                <div align="center"><%=p.getCategory()%></div>
            </td>
            <td width="10%">
                <div align="center"><%=p.getPrice1()%></div>
            </td>
            <td width="12%"><div align="center">
                <img height="25" hspace="0" src="<%=path %>/static/images/<%=p.getImagepath() %>" width="83" border="0" />
                </div>
            </td>
            <td width="13%">
                <div align="center">
                    <a href="cart? pid=<%=p.getId()%>">购买</a>
                </div>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</center>

</body>
</html>
