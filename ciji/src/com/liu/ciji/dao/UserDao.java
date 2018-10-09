package com.liu.ciji.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.ciji.entity.User;
import com.liu.cijiUtil.DBUtils;

public class UserDao {

	public User login(String name, String password) {
		String sql = "select * from cijiwar where name=? and password=?";
		User user = null;
		try {
			ResultSet rs = DBUtils.doQuery(sql, name, password);
			while(rs.next()){
				user = new User(rs.getString("name"), rs.getString("password"), rs.getInt("id"), 
						rs.getString("sex"), rs.getInt("kills"), 
						rs.getInt("daths"), rs.getString("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean AddUser(User user) {
		String sql = "insert into cijiwar (name,password,id,sex,kills,daths,level) "
				+ "values (?,?,?,?,?,?,?)";
		return DBUtils.doUpdate(sql, user.getName(),user.getPassword()
				,user.getId(),user.getSex(),user.getKills(),user.getDaths()
				,user.getLevel());
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from cijiwar";
		try {
			ResultSet rs = DBUtils.doQuery(sql, null);
			while(rs.next()){
				User user = new User(rs.getString("name"), rs.getString("password"), 
						rs.getInt("id"), rs.getString("sex"), rs.getInt("kills"), 
						rs.getInt("daths"), rs.getString("level"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteUser(int id) {
		String sql = "delete from cijiwar where id = ?";
		return DBUtils.doUpdate(sql, id);
	}

	public boolean doUpdate(User user) {
		String sql = "update cijiwar set name=?,password=?,sex=?,"
				+ "kills=?,daths=?,level=? where id=?";
		return DBUtils.doUpdate(sql, user.getName(),user.getPassword(),
				user.getSex(),user.getKills(),user.getDaths(),user.getLevel(),user.getId());
	}

	public User findById(int id) {
		User user = null;
		String sql = "select * from cijiwar where id=?";
		ResultSet rs = DBUtils.doQuery(sql, id);
		try {
			while(rs.next()){
				user = new User(rs.getString("name"), rs.getString("password"),
						rs.getInt("id"), rs.getString("sex"), rs.getInt("kills"),
						rs.getInt("daths"), rs.getString("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findByName(String name) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from cijiwar where name like ?";
		name = "%" + name + "%";
		ResultSet rs = DBUtils.doQuery(sql, name);
		try {
			while(rs.next()){
				User user = new User(rs.getString("name"), rs.getString("password"), 
						rs.getInt("id"), rs.getString("sex"), rs.getInt("kills"),
						rs.getInt("daths"), rs.getString("level"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
