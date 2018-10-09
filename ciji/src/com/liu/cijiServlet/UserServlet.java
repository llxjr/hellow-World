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
		//1.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.�Ȼ�ȡop�жϲ���
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
		//��ȡ����
		String name =request.getParameter("name");
		//����dao
		UserDao dao = new UserDao();
		List<User> list = dao.findByName(name);
		if(list!=null&&list.size()>0){
			//������ŵ�request��
			request.setAttribute("list", list);
			request.getRequestDispatcher("findall.jsp").forward(request, response);
		}
	}


	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		int id = Integer.parseInt(request.getParameter("id"));
		//����dao
		UserDao dao = new UserDao();
		User user = dao.findById(id);
		if(user!=null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		}
	}


	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����,����getANewUser
		User user = this.getANewUser(request, response);
		//����dao��
		UserDao dao = new UserDao();
		boolean flag = dao.doUpdate(user);
		if(flag){
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		//����dao
		UserDao dao = new UserDao();
		boolean flag = dao.deleteUser(id);
		if(flag){
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
	}


	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���������������getANewUser(request,response)�������������һ��user�󷵻ظ�user
		//���ڽ��addUser��registerʱ�����Ĵ�������
		User user = this.getANewUser(request,response);
		//����dao
		UserDao dao = new UserDao();
		if(dao.AddUser(user)){//����˵�����ӳɹ�
			//���ӳɹ�����������Ϣ��ѯ����
			request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		}
	}

	/*
	 * ��ӻ���ע�ᶼ����Ҫ�������ȫ�����ݣ���������ɴ������࣬�÷���Ϊ�˽����������
	 * ��ȡ��������������������װ��һ���µ�user�����ظ�user
	 */
	private User getANewUser(HttpServletRequest request, HttpServletResponse response) {
		//��ȡ�������
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
		//����dao��
		UserDao dao = new UserDao();
		List<User> list = dao.findAll();
		//�ѽ���ŵ�request���У�
		request.setAttribute("list", list);
		//��תҳ��
		request.getRequestDispatcher("findall.jsp").forward(request, response);
	}


	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println(name);
		UserDao dao = new UserDao();
		User user = this.getANewUser(request, response);
		//���ݽ���ɷ�ҳ��
		if(dao.AddUser(user)){//����˵�����ӳɹ�
			//���ӳɹ�����������Ϣ��ѯ����
			request.getRequestDispatcher("UserServlet?op=findall").forward(request, response);
		}
		
	}
	
	
	
}
