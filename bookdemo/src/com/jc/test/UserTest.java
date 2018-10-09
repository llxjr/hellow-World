package com.jc.test;

import org.junit.Test;

import com.jc.dao.UserDAO;
import com.jc.entity.User;

public class UserTest {
	@Test
	public void saveTest(){
		UserDAO userDao = new UserDAO();
		User user = new User("Ì¹¿Ë", "123", 1);
		userDao.save(user);
	}
	@Test
	public void save2Test(){
		UserDAO userDao = new UserDAO();
		User user = new User("Ì¹¿Ë", "123", 1);
//		userDao.save2(user);
	}
}
