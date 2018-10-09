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
		//1.���봦��
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.��ȡ����(getParameter:��ȡ��������)
		//���ݱ��е�name���Ի�ȡ������
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		//3.����dao
		UserDao dao = new UserDao();
		User user = dao.login(name, password);
		if(user!=null){//˵���в�ѯ������ˣ���ζ�ŵ�½�ɹ�
			response.sendRedirect("loginSuccess.jsp");//�ض���
		}else{
			response.sendRedirect("index.jsp");//�ض���
		}
	}

}
