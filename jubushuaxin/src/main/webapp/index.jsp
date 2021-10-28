<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>局部刷新</title>
    <script type="text/javascript">
        //使用内存中的异步对象，代替浏览器发起请求。
        function doAjax() {
            //1.创建异步对象
            var xmlHttp;
            if (window.XMLHttpRequest) {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlHttp = new XMLHttpRequest();
            } else {
                // IE6, IE5 浏览器执行代码
                xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
            }
            //2.绑定事件
            xmlHttp.onreadystatechange = function () {
                //alert("readyState="+xmlHttp.readyState+"---status"+xmlHttp.status);
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    var oMsg=document.getElementById("msg");
                    //alert(xmlHttp.responseText);//后端应答的值
                    var data=xmlHttp.responseText;
                    oMsg.innerText=data;
                    data=JSON.parse(data)
                    oMsg.innerText=data.name;
                }
            }


            //3.初始请求数据
            //获取dom对象的value值
            var name = document.getElementById("name").value;
            var weight = document.getElementById("weight").value;
            var height = document.getElementById("height").value;

            //拼接带参的请求地址
            var paramURL = "bmiAjax?name=" + name + "&weight=" + weight + "&height=" + height;

            alert(paramURL);

            xmlHttp.open("get", paramURL, true);

            //4.发起请求
            xmlHttp.send();
        }

    </script>
</head>
<body>
<p>局部刷新ajax计算bmi</p>
<div>
    <%--不用表单--%>
    姓名：<input type="text" id="name"><br>
    体重（公斤）<input type="text" id="weight"><br>
    身高（米）<input type="text" id="height"><br>
    <input type="button" value="计算bmi" onclick="doAjax()">
    <p id="msg">数据。。。。。</p>
</div>
</body>
</html>