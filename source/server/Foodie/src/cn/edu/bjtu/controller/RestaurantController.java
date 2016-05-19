/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="insertRestaurant")
	@ResponseBody
	public String insertNewRes(Restaurant res) throws JSONException{
		String code = "{\"code\":\"";
		Restaurant restauSaved = restaurantService.insertRestaurant(res);
		code = code + restauSaved.getId() + "\"}";
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String restauLogin(String name,String password) throws JSONException{
		String code = "{\"code\":\"";
		Restaurant res = restaurantService.checkLogin(name, password);
		if(res!=null){
			code = code + res.getId() + "\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
	
	@RequestMapping("getRestaurantById")
	@ResponseBody
	public String getRestaurantbyid(String restaurantid){
		Restaurant re = restaurantService.getRestaurantById(restaurantid);
		List<Restaurant> r = new ArrayList<Restaurant>();
		r.add(re);
		JSONArray restaurant = JSONArray.fromObject(r);
		return restaurant.toString();
	}

}
