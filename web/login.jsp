<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/5
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="/LoginServlet" method="post">
    <table align="center">
        <td>
            <tr>用户名</tr>
            <tr><input type="text" name="username"></tr>
        </td>
        <td>
            <tr>密码</tr>
            <tr><input type="password" name="password"></tr>
        </td>
        <td>
            <tr><input type="submit" value="提交"></tr>
        </td>
    </table>
</form>
</body>
</html>
