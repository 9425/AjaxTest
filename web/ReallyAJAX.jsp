<%--
  Created by IntelliJ IDEA.
  User: yang hui
  Date: 2020/11/19
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReallyAJAX</title>
    <script type="text/javascript">
        /*
        * 使用内存中的异步对象，代替浏览器发起请求，异步对象使用js创建和管理
        * */
           /* function doAJAX() {
                //创建异步对象
                var xmlHttp=new XMLHttpRequest();
                //绑定事件
                xmlHttp.onreadystatechange=function () {
                    alert("readyState属性值："+xmlHttp.readyState)
                }
                //初始化请求数据
                //获取dom对象的value属性值
                var name=document.getElementById("name").value;
                var weight=document.getElementById("weight").value;
                var height=document.getElementById("height").value;

                //bmiPrint?name=lisi&weight=82&eight=1.8
                var param="name="+name+"&w"+weight+"&height="+height;
                alert("param="+param);
                xmlHttp.open("get","bmi03?"+param)
                //发起请求
                xmlHttp.send();
            }*/
           function doAJAX() {
               //创建异步对象
               var xmlHttp=new XMLHttpRequest();
               //绑定事件
               xmlHttp.onreadystatechange=function(){
                   //alert(xmlHttp.readyState)
                   if (xmlHttp.readyState==4&&xmlHttp.status==200){
                       //alert(xmlHttp.responseText);

                       //获取需要传输到dom对象的数据
                       var data=xmlHttp.responseText;
                       //更新dom对象，更新页面数据
                       document.getElementById("myData").innerText=data;
                   }
               }
               //初始化请求数据
               //获取dom对象的value属性值
               var name=document.getElementById("name").value;
               var weight=document.getElementById("weight").value;
               var height=document.getElementById("height").value;
               //将获取的value进行拼接，组合为需要发送的地址
               var param="name="+name+"&weight="+weight+"&height="+height;
               //将请求对象进行装载，进行发送
               xmlHttp.open("get","bmi03?"+param,true);//选择异步方式进行发送
               //alert("测试成功...")
               //alert(param)
               //发起请求
               xmlHttp.send();
           }
    </script>
</head>
<body onload="doAJAX()">
<CENTER>
    <P>局部刷新计算bmi</P>
    <table border="2" align="center">
        <tr>
            <td>姓名：<input type="text " id="name"/></td>
        </tr>
        <tr>
            <td>体重(公斤)：<input type="text" id="weight"/></td>
        </tr>
        <tr>
            <td>身高(米)：<input type="text" id="height"/></td>
        </tr>
        <tr>
            <td><input type="button" value="计算bmi" onclick="doAJAX()"/></td>
        </tr>
    </table>
    <div id="myData">等待数据加载...</div>
</CENTER>
</body>
</html>
