package com.liu.cijiServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.ciji.dao.UserDao;
import com.liu.ciji.entity.User;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.先获取op判断操作
		String op = request.getParameter("op");
		if("adduser".equals(op)){
			addUser(request, response);
		}else if("findall".equals(op)){
			findAll(request, response);
		}else if("register".equals(op)){
			register(request, response);
		}else if("deleteuser".equals(op)){
			deleteUser(request, response);
		}else if("findbyid".equals(op)){
			findById(request, response);
		}else if("doupdate".equals(op)){
			doupdate(request, response);
		}else if("searchsuser".equals(op)){
			searchUser(request, response);
		}else if("deletemore".equals(op)){
			deleteMore(request, response);
		}
		
	}


	private void deleteMore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("ids");
		String[] id_s = ids.split(",");
		UserDao dao = new UserDao();
		
		for (String id: id_s) {
			dao.deleteUser(Integer.parseInt(id));
			System.out.println(id);
		}
		request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
	}


	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String name =request.getParameter("name");
		//调用dao
		UserDao dao = new UserDao();
		List<User> list = dao.findByName(name);
		if(list!=null&&list.size()>0){
			//将结果放到request域
			request.setAttribute("list", list);
			request.getRequestDispatcher("findall.jsp").forward(request, response);
		}
	}


	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		int id = Integer.parseInt(request.getParameter("id"));
		//调用dao
		UserDao dao = new UserDao();
		User user = dao.findById(id);
		if(user!=null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		}
	}


	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数,调用getANewUser
		User user = this.getANewUser(request, response);
		//调用dao层
		UserDao dao = new UserDao();
		boolean flag = dao.doUpdate(user);
		if(flag){
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		//调用dao
		UserDao dao = new UserDao();
		boolean flag = dao.deleteUser(id);
		if(flag){
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
	}


	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数，并调用getANewUser(request,response)将请求参数放入一个user后返回该user
		//用于解决addUser和register时产生的代码冗余
		User user = this.getANewUser(request,response);
		//调用dao
		UserDao dao = new UserDao();
		if(dao.AddUser(user)){//进来说明增加成功
			//增加成功，把所以信息查询出来
			request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		}
	}

	/*
	 * 添加或者注册都需需要进行添加全部数据，这样会造成代码冗余，该方法为了解决代码冗余
	 * 获取请求参数，将请求参数封装到一个新的user，返回该user
	 */
	private User getANewUser(HttpServletRequest request, HttpServletResponse response) {
		//获取请求参数
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String sex = request.getParameter("sex");
		int kills = Integer.parseInt(request.getParameter("kills"));
		int daths = Integer.parseInt(request.getParameter("daths"));
		String level = request.getParameter("level");
		String password = request.getParameter("password");
		User user = new User(name, password, id, sex, kills, daths, level);
		return user;
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用dao层
		UserDao dao = new UserDao();
		List<User> list = dao.findAll();
		//把结果放到request域中，
		request.setAttribute("list", list);
		//跳转页面
		request.getRequestDispatcher("findall.jsp").forward(request, response);
	}


	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println(name);
		UserDao dao = new UserDao();
		User user = this.getANewUser(request, response);
		//根据结果派发页面
		if(dao.AddUser(user)){//进来说明增加成功
			//增加成功，把所以信息查询出来
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
		
	}
	
	
	
}
