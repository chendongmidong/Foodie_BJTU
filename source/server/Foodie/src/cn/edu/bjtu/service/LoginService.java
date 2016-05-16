package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.User;

public interface LoginService {
	
	public User checkLogin(String username,String password);
}
