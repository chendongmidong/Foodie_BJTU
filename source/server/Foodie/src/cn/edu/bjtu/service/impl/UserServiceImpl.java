/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.UserDao;
import cn.edu.bjtu.service.UserService;
import cn.edu.bjtu.util.FoodieUploadFile;
import cn.edu.bjtu.vo.User;

/**
 * @author solitude
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		String hql = "from User";
		return userDao.find(hql);
	}

	@Override
	public String updateUserAvatar(int userid, String strImageContent, String type) {
		String url = FoodieUploadFile.mobileuploadFile(userid+"", strImageContent, type);
		String hql = "from User where id='"+userid+"'";
		User user = userDao.get(hql);
		user.setAvatar(url);
		
		userDao.update(user);
		
		return url;
	}

}
