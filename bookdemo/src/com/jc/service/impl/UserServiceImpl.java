package com.jc.service.impl;

import com.jc.dao.UserDAO;
import com.jc.entity.User;
import com.jc.service.UserService;

public class UserServiceImpl implements UserService {
	//ʹ��spring��daoע��
	private UserDAO userDao;
	//����set��������spring����ע��
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	@Override
	public void login(User user) {
//		userDao.login(user);
	}

}
