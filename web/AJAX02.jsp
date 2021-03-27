<%--
  Created by IntelliJ IDEA.
  User: yang hui
  Date: 2020/11/18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX02</title>
</head>
<body>
<CENTER>
    <form action="/bmi2" method="get">
        <table border="2" align="center">
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
                <td><input type="submit" value="提交"/>
                    <input type="reset"/>
                </td>
            </tr>
        </table>
    </form>
</CENTER>
</body>
</html>
