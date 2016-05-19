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

import cn.edu.bjtu.service.LoginService;
import cn.edu.bjtu.vo.User;

/**
 * @author solitude
 *
 */
@Controller
@RequestMapping(value="/user",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="login")
	@ResponseBody
	public String login(String username,String password) throws JSONException{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User getFromDatabase = loginService.checkLogin(user.getUsername(), user.getPassword());
		String code = "{\"code\":\"";
		if(getFromDatabase!=null){
			code = code +getFromDatabase.getId()+"\"}";
		}else{
			code = code +"0\"}";
		}
		JSONObject result = new JSONObject(code);
		return result.toString();
	}

}
