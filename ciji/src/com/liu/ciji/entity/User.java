package com.liu.ciji.entity;

public class User {
	private String name;
	private String password;
	private int id;
	private String sex;
	private int kills;
	private int daths;
	private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kill) {
		this.kills = kill;
	}
	public int getDaths() {
		return daths;
	}
	public void setDaths(int dath) {
		this.daths = dath;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
	public User() {
		super();
	}
	
	public User(String name, String password, int id, String sex, int kill, int dath, String level) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
		this.sex = sex;
		this.kills = kill;
		this.daths = dath;
		this.level = level;
	}
	
	
}
