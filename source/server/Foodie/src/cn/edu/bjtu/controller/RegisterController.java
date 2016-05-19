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
	
	@RequestMapping(value="register")
	@ResponseBody
	public String userRegist(String username,String password,String phone,String strImageContent) throws JSONException{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		String code = "{\"code\":\""+registerService.regist(user,strImageContent)+"\"}";
		JSONObject result = new JSONObject(code);
		return result.toString();
	}

}
