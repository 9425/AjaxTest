<%--
  Created by IntelliJ IDEA.
  User: yang hui
  Date: 2020/11/19
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Province</title>
    <script type="text/javascript">
        function search() {
            //创建异步对象
            var xmlHttp=new XMLHttpRequest();
            //绑定事件
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                    //更新dom对象
                    //alert(xmlHttp.readyState);
                    //alert(xmlHttp.responseText);
                    document.getElementById("proName").value=xmlHttp.responseText;
                }
            }
            //初始化异步对象，也就是进行值的传递
            var proId=document.getElementById("proId").value;
            xmlHttp.open("get","queryProvince?proId="+proId,true);
            //alert(proId)//id能够进行传递
            xmlHttp.send();
        }
    </script>
</head>
<body onload="search()">
<center>
    <p>根据省份的id获取名称</p>
    <table border="2" align="center">
        <tr>
            <td>省份编号：</td>
            <td><input type="text" id="proId"/>
                <input type="button" value="搜索" onclick="search()"/>
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td>
                <input type="text" id="proName"/>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
