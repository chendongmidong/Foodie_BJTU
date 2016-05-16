<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Moment</title>
</head>
<body>
        <h1>Moment管理界面</h1><br><br>
        <div>
           <form action="/Foodie/insertMoment">
               name:<input type="text" name="name" /><br>
               avatorUrl:<input type="text" name="avatorUrl" /><br>
               content:<input type="text" name="content" /><br>
               imageUrls:<input type="text" name="imageUrls" /><br>
               <input type="submit" value="提交">
           </form>       
        </div>
</body>
</html>