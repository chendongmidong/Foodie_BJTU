/**
 * 
 */
package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.RegisterDao;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.User;

/**
 * @author solitude
 *
 */
@Transactional
@Repository
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDao registerDao;

	@Override
	public int regist(User user) {
		if((user.getUsername()+"").equals("")||(user.getUsername()+"").equals("null")){
			return -1;
		}
		user.setId(IdCreator.createUserId());
		User u = registerDao.get("from User where username='"+user.getUsername()+"'");
		if(!((u.getUsername()).equals((user.getUsername())))){
		   registerDao.save(user);
		   return user.getId();
		}
		return -1;
	}

}
