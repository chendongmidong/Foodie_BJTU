/**
 * 
 */
package cn.edu.bjtu.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bjtu.edu.bean.ActivityBean;
import cn.edu.bjtu.service.ActivityService;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/activity",produces="text/html;charset=UTF-8")
public class ActivityController {
	@Autowired
	ActivityService activityService;
	
	@RequestMapping("newActivity")
	@ResponseBody
	public String addActivity(ActivityBean activityBean) throws JSONException{
		
		String code = "{\"code\":\"";
		
		if(activityService.addactivity(activityBean)){
			code = code +"1\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
}
