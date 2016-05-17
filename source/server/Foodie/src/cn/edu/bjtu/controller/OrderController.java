/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bjtu.edu.bean.OrderBean;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.vo.Orderinfo;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/order",produces="text/html;charset=UTF-8")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("addorder")
	@ResponseBody
	public String insertNewOrder(OrderBean orderBean) throws JSONException{
		Orderinfo order = new Orderinfo();
		order.setDishes(orderBean.getDishes());
		order.setRestaurantid(orderBean.getRestaurantid());
		order.setSeats(orderBean.getSeats());
		int userid = Integer.valueOf(orderBean.getUserid());
		order.setUserid(userid);
		String time = orderBean.getTime();
		long t = Long.valueOf(time);
		Date relTime = new Date(t);
		order.setTime(relTime);
		
		String code = "{\"code\":\"";
		if(orderService.insertOrder(order)){
			code = code + "1\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}

}
