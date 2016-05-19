/**
 * 
 */
package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.User;

/**
 * @author solitude
 *
 */
public interface UserService {
	
	public List<User> getAllUsers();
	
	public String updateUserAvatar(int userid,String strImageContent,String type);
	
	public List<User> getFriends(String userid);

}
