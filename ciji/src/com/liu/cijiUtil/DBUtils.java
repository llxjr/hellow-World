package com.liu.cijiUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/java01?useUnicode=true&characterEncoding=UTF-8";
	private static final String username="root";
	private static final String password="";
	
	
	//��ȡ����
	public static PreparedStatement getPre(String sql,Object...params){
		PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	/**
	 * ��ѯ��executeQuery()
	 * ��ɾ��:executeUpdate();
	 */
	/**
	 * �۲죺
	 * 	select * from user ;
	 * 	select * from user where uid = 1;
	 * 	select * from user where uname = "��" and password="123";
	 * �Ҳ�ͬ��
	 * 	1.��ѯ��䲻һ���������������sql��������������
	 * 	2.��ѯ������һ��
	 * 		�������ͣ�Object
	 * 		����������...  ����̬������	
	 */
	//��ѯͨ�÷���
	public static ResultSet doQuery(String sql,Object...params){
		PreparedStatement pstmt=getPre(sql,params);
		ResultSet rs=null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//��ɾ��ͨ�÷���
	public static boolean doUpdate(String sql,Object...params) {
			PreparedStatement pstmt=getPre(sql,params);
			try {
				pstmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
}
