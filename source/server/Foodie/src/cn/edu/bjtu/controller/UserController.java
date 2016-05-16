/**
 * 
 */
package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.UserService;
import cn.edu.bjtu.vo.User;
import net.sf.json.JSONArray;

/**
 * @author solitude
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="user/getUsers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUsers(){
		List<User> userList = userService.getAllUsers();
		JSONArray users = JSONArray.fromObject(userList);
		return users.toString();
	}

}
