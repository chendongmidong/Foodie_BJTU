/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

import cn.bjtu.edu.bean.OrderBean;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.OrderinfoUserViewService;
import cn.edu.bjtu.util.ParseTime;
import cn.edu.bjtu.vo.Orderinfo;
import cn.edu.bjtu.vo.Orderinfo_User_View;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/order",produces="text/html;charset=UTF-8")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderinfoUserViewService oService;
	
	@RequestMapping("addorder")
	@ResponseBody
	public String insertNewOrder(OrderBean orderBean) throws JSONException{
		Orderinfo order = new Orderinfo();
		if(((orderBean.getDishes())!=null)&&((orderBean.getDishes()).length()!=0)){
			order.setDishes(orderBean.getDishes());
		}
		order.setRestaurantid(orderBean.getRestaurantid());
		if(((orderBean.getSeats())!=null)&&((orderBean.getSeats()).length()!=0)){
			order.setSeats(orderBean.getSeats());
		}
		if(((orderBean.getUserid())!=null)&&((orderBean.getUserid()).length()!=0)){
			int userid = Integer.valueOf(orderBean.getUserid());
			order.setUserid(userid);
		}
		if(orderBean.getTime()!=null&&(!(orderBean.getTime().equals("")))){
			String time = orderBean.getTime();
			long t = Long.valueOf(ParseTime.parseStrTime(time));
			Date relTime = new Date(t);
			order.setTime(relTime);
		}
		
		String code = "{\"code\":\"";
		if(orderService.insertOrder(order)){
			code = code + "1\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
	
	@RequestMapping("getOrdersByRestaurantid")
	@ResponseBody
	public String getOrdersByRestauId(String restaurantid){
		List<Orderinfo_User_View> orders = orderService.getOrdersByRestauId(restaurantid);
		JSONArray orders_json = JSONArray.fromObject(orders);
		return orders_json.toString();
	}

}
