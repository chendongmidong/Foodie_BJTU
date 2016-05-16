/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.bjtu.edu.bean.RestaurantBean;
import cn.edu.bjtu.service.RestaurantService;
import cn.edu.bjtu.vo.Restaurant;
import net.sf.json.JSONArray;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/restaurants",produces="text/html;charset=UTF-8")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping("getRestaurants")
	@ResponseBody
	public String getAllRestaurants(){
		
		List<Restaurant> restaus = restaurantService.getAllRestaurants();
		List<RestaurantBean> restausBeans = new ArrayList<RestaurantBean>();
		for(int i=0;i<restaus.size();i++){
			Restaurant re = restaus.get(i);
			RestaurantBean reBean = new RestaurantBean();
			reBean.setAddress(re.getAddress());
			reBean.setAvatarUrl(re.getAvatarUrl());
			reBean.setName(re.getName());
			reBean.setScore(re.getScore());
			
			restausBeans.add(reBean);
		}
		
		JSONArray restaurants = JSONArray.fromObject(restausBeans);
		return restaurants.toString();
	}
	
	@RequestMapping(value="getRestaurant")
	@ResponseBody
	public String getRestaurant(String name){
		Restaurant restau = restaurantService.getRestaurantByName(name);
		List<Restaurant> re = new ArrayList<Restaurant>();
		re.add(restau);
		JSONArray restaurant = JSONArray.fromObject(re);
		return restaurant.toString();
	}

}
