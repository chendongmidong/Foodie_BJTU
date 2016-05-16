<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Foodie</title>
</head>
<body>
     <h1>Foodie，欢迎你！</h1><br><br>
     <a href="views/moment.jsp">跳转到Moment管理界面</a><br><br>
     <h2>注册用户</h2><br><br>
     <form action="user/register" method="post">
            username:<input type="text" name="username"><br><br>
            password:<input type="text" name="password"><br><br>
            phone:<input type="text" name="phone"><br><br>
            avatar:<input type="text" name="avatar"><br><br>
            <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>用户登录</h2><br>
     <form action="user/login" method="post">
            username:<input type="text" name="username"><br>
            password:<input type="text" name="password"><br>
            <input type="submit" value="提交">
     </form>
     <br><br>
     <a href="user/getUsers"><h2>获取所有用户</h2></a>
     <br><br>
     <h2>根据name获取餐馆</h2><br><br>
     <form action="restaurants/getRestaurant">
           name:<input type="text" name="name"><br>
           <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>通过餐馆ID获取Coupons</h2>
     <form action="coupon/getCouponsByRestauId">
                            餐馆ID:<input type="text" name="restaurantId"><br>
           <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>通过餐馆ID获取Dishes</h2>
     <form action="dish/getDishesByRestauId">
                            餐馆ID:<input type="text" name="restaurantId"><br>
           <input type="submit" value="提交">
     </form>
</body>
</html>