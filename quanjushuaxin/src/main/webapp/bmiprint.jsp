<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>全局刷新</title>
</head>
<body>
    <p>通过全局刷新计算bmi</p>
    <form action="bmiPrintServlet" method="get">
        姓名：<input type="text" name="name"><br>
        体重(公斤)：<input type="text" name="weight"><br>
        身高(米)：<input type="text" name="height"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>