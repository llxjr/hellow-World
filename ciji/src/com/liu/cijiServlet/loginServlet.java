package com.liu.cijiServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.ciji.dao.UserDao;
import com.liu.ciji.entity.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.编码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.获取参数(getParameter:获取参数方法)
		//根据表单中的name属性获取参数的
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		//3.调用dao
		UserDao dao = new UserDao();
		User user = dao.login(name, password);
		if(user!=null){//说明有查询出这个人，意味着登陆成功
			response.sendRedirect("loginSuccess.jsp");//重定向
		}else{
			response.sendRedirect("index.jsp");//重定向
		}
	}

}
