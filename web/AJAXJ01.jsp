<%--
  Created by IntelliJ IDEA.
  User: yang hui
  Date: 2020/11/18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAXJSP</title>
</head>
<body>
<center>
    <p>全局刷新计算</p>
    <form action="/bmi" method="get">
        <table>
            <tr>
                <td>姓名：<input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>体重(公斤)：<input type="text" name="weight"/></td>
            </tr>
            <tr>
                <td>身高(米)：<input type="text" name="height"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
