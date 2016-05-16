package cn.edu.bjtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.service.LoginService;
import cn.edu.bjtu.vo.User;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{	
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public User checkLogin(String username, String password) {
		String hql="from User where username='"+username+"' and password='"+password+"'";
		
		return loginDao.get(hql);
	}

}
