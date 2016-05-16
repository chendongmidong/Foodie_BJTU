package cn.edu.bjtu.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.vo.User;

@Repository
public class LoginDaoImpl extends BaseDaoImpl<User> implements LoginDao {
}
