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
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="user/updateAvatar",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String saveAvatar(String userid,String strImageContent) throws JSONException{
		String type = "user";
		int id = Integer.valueOf(userid);
		String address = userService.updateUserAvatar(id, strImageContent, type);
		String relAddress = "http://123.56.143.59:8585/Foodie/images/user/"+userid+"."+"jpg";
		String code = "{\"url\":\""+relAddress+"\"}";
		
		JSONObject result = new JSONObject(code);
		return result.toString();
	}
	
	@RequestMapping(value="user/getFriends",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMyFriends(String userid){
		List<User> friends = userService.getFriends(userid);
		JSONArray friends_json = JSONArray.fromObject(friends);
		return friends_json.toString();
	}

}
