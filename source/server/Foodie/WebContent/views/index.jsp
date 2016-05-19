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
            strImageContent:<input type="text" name="strImageContent"><br><br>
            <input type="submit" value="提交"> 
     </form>
     <br><br>
     <h2>用户登录</h2><br>
     <form action="user/login" method="get">
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
     <br><br>
     <h2>测试JPush</h2><br><br>
     <form action="test1">
         <input type="submit" value="测试1">
     </form><br>
     <form action="test2">
         <input type="submit" value="测试2">
     </form><br>
     <form action="test3">
         <input type="submit" value="测试3">
     </form><br>
     <form action="test4">
         <input type="submit" value="测试4">
     </form><br>
     <form action="test5">
         <input type="submit" value="测试5">
     </form><br>
     <form action="test6">
         <input type="submit" value="测试6">
     </form><br>
     <br><br>
     <h2>测试更新用户头像</h2>
     <form action="user/updateAvatar" method="post">
         userid:<input type="text" name="userid"><br>
         strImageContent:<input type="text" name="strImageContent"><br>
         <input type="submit" value="提交">
     </form><br><br>
     <h2>测试更新Moments的图像</h2><br><br>
     <form action="moments/updateImageUrls" method="post">
         userid:<input type="text" name="userid"><br>
         strImageContent:<input type="text" name="strImageContent"><br>
         <input type="submit" value="提交">
     </form>
     <br><br>
     <a href="views/restaurant/foodies/foodies.html">餐馆管理界面</a>
     <br><br>
     <h2>获取我的Friends</h2><br><br>
     <form action="user/getFriends">
          userid:<input type="text" name="userid"><br>
          <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>添加订单</h2><br>
     <form action="order/addorder">
          userid:<input type="text" name="userid"><br>
          restaurantid:<input type="text" name="restaurantid"><br>
          time:<input type="text" name="time"><br>
          dishes:<input type="text" name="dishes"><br>
          seats:<input type="text" name="seats"><br>
          <input type="submit" value="提交">
     </form>
     <h2>添加Moment</h2><br>
     <form action="moments/insertMoment" method="get">
          name:<input name="name" type="text"><br>
          avatorUrl:<input name="avatorUrl" type="text"><br>
          content:<input type="text" name="content"><br>
          imageUrls:<input type="text" name="imageUrls"><br>
          userid:<input type="text" name="userid"><br>
          <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>添加餐馆</h2><br>
     <form action="restaurants/insertRestaurant" method="get">
          avatarUrl:<input type="text" name="avatarUrl"><br>
          name:<input type="text" name="name"><br>
          address:<input type="text" name="address"><br>
          phone:<input type="text" name="phone"><br>
          intro:<input type="text" name="intro"><br>
          password:<input type="text" name="password"><br>
          <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>餐馆登录</h2><br>
     <form action="restaurants/login" method="get">
          name:<input type="text" name="name"><br> 
          password:<input type="text" name="password"><br>
          <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>添加Dish</h2><br>
     <form action="dish/insertDish" method="get">
          price:<input type="text" name="price"><br>
          name:<input type="text" name="name"><br>
          category:<input type="text" name="category"><br>
          score:<input type="text" name="score"><br>
          frequency:<input type="text" name="frequency"><br>
          restaurantid:<input type="text" name="restaurantid"><br>
          photo:<input type="text" name="photo"><br>
          <input type="submit" value="提交">
     </form>
     <br><br>
     <h2>根据餐馆ID获取该餐馆的所有订单</h2><br>
     <form action="order/getOrdersByRestaurantid" method="get">
          restaurantid:<input type="text" name="restaurantid"><br> 
          <input type="submit" value="提交">
     </form>
     
     <br><br>
     <h2>发起活动</h2><br>
     <form action="activity/newActivity">
         name:<input type="text" name="name"><br>
         time:<input type="text" name="time"><br>   
         location:<input type="text" name="location"><br>  
         userid:<input type="text" name="userid"><br> 
         <input type="submit" value="提交"> 
     </form>
     
     <br><br>
     <h2>根据ID获取餐馆</h2><br>
     <form action="restaurants/getRestaurantById">
         restaurantid:<input type="text" name="restaurantid"><br>
         <input type="submit" value="提交"> 
     </form>
     
     <br><br>
     <h2>List</h2><br>
     <form action="sequence/list">
         userid:<input type="text" name="userid"><br>
         type:<input type="text" name="type"><br>
         <input type="submit" value="提交"> 
     </form>
     
</body>
</html>