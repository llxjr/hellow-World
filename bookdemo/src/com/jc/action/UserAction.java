package com.jc.action;

import com.jc.entity.User;
import com.jc.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	//手动创建实体类对象
	private User user = new User();
	//创建UserService
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 登录
	 */
	public void login() {
		userService.login(user);
		System.out.println("登录Action:"+user);
	}
	
	/**
	 * 添加用户
	 */
	public void adduser(){
//		userService.addUser(user);
		System.out.println("添加用户"+user);
	}
}
