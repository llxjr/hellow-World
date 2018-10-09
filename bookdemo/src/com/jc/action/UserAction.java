package com.jc.action;

import com.jc.entity.User;
import com.jc.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	//�ֶ�����ʵ�������
	private User user = new User();
	//����UserService
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
	 * ��¼
	 */
	public void login() {
		userService.login(user);
		System.out.println("��¼Action:"+user);
	}
	
	/**
	 * ����û�
	 */
	public void adduser(){
//		userService.addUser(user);
		System.out.println("����û�"+user);
	}
}
