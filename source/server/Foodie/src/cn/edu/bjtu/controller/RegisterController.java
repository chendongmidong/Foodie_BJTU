/**
 * 
 */
package cn.edu.bjtu.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.vo.User;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/user",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("register")
	@ResponseBody
	public String userRegist(User user) throws JSONException{
		String code = "{\"code\":\""+registerService.regist(user)+"\"}";
		JSONObject result = new JSONObject(code);
		return result.toString();
	}

}
