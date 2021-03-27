<%--
  Created by IntelliJ IDEA.
  User: yang hui
  Date: 2020/11/19
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProvinceAll</title>
    <script type="text/javascript">
        function doSearch() {
            //1.创建异步对象
            var xmlHttp=new XMLHttpRequest();
            //2.绑定事件
            xmlHttp.onreadystatechange=function () {
                /*alert(xmlHttp.readyState);
                alert(xmlHttp.responseText)*/
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                    var data=xmlHttp.responseText;
                    //alert(data)
                    //使用eval。eval的作用是将括号中的代码，将json字符串转换为json代码
                    var jsonObj=eval("("+data+")")
                    //更新dom对象
                    callback(jsonObj)
                }
            }
            //3.初始异步对象的请求参数
            var proId=document.getElementById("proId").value;
            xmlHttp.open("get","queryjson?proId="+proId,true);
            ///4.发送请求
            xmlHttp.send();
        }
        function callback(json) {
            document.getElementById("proName").value=json.name
            document.getElementById("proJianCheng").value=json.jianCheng;
            document.getElementById("proShengHui").value=json.shengHui;
        }
    </script>
</head>
<body onload="doSearch()">
<center>
    <p>使用json格式输出数据</p>
    <table border="2" align="center">
        <tr>
            <td>省份编号：</td>
            <td>
                <input type="text" id="proId"/>
                <input type="button" value="搜索" id="btn" onclick="doSearch()"/>
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td><input type="text" id="proName"/></td>
        </tr>
        <tr>
            <td>省份简称：</td>
            <td><input type="text" id="proJianCheng"/></td>
        </tr>
        <tr>
            <td>省会名称：</td>
            <td><input type="text" id="proShengHui"/></td>
        </tr>
    </table>
</center>
</body>
</html>
