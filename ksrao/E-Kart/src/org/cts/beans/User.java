package org.cts.beans;

public class User {
	private int id;
	private String uname;
	private String pwd;
	private String role;
	public User()
	{
		
	}
	public User(String uname, String pwd, String role) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
