package com.jc.service.impl;

import com.jc.dao.UserDAO;
import com.jc.entity.User;
import com.jc.service.UserService;

public class UserServiceImpl implements UserService {
	//使用spring将dao注入
	private UserDAO userDao;
	//创建set方法方便spring进行注入
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	@Override
	public void login(User user) {
//		userDao.login(user);
	}

}
