/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.DishService;
import cn.edu.bjtu.vo.Dish;
import net.sf.json.JSONArray;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/dish",produces="text/html;charset=UTF-8")
public class DishController {
	@Autowired
	DishService dishService;
	
	@RequestMapping(value="getDishesByRestauId")
	@ResponseBody
	public String getDishesByRestauId(String restaurantId){
		List<Dish> dishes = dishService.getDishesByRestauId(restaurantId);
		JSONArray dish = JSONArray.fromObject(dishes);
		return dish.toString();
	}
	
	@RequestMapping("insertDish")
	@ResponseBody
	public String insertDish(Dish dish) throws JSONException{
		String code = "{\"code\":\"";
		if(dishService.insertDish(dish)){
			code = code +"1\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
}
