package com.daipeng.ssi.action;

import com.daipeng.ssi.entity.User;
import com.daipeng.ssi.service.UserDaoServiceInter;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserDaoServiceInter userdaoServiceInter;

	public UserDaoServiceInter getUserdaoServiceInter() {
		return userdaoServiceInter;
	}

	public void setUserdaoServiceInter(UserDaoServiceInter userdaoServiceInter) {
		this.userdaoServiceInter = userdaoServiceInter;
	}

	private String name; // 用户名
	private String password; // 密码
	private String username; // 昵称
	private String address; // 地址

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public String addUser() {
		System.out.println("添加成功！");
		User user = new User();

		String name = this.name;
		String password = this.password;
		String username = this.username;
		String address = this.address;

		user.setName(name);
		user.setPassword(password);
		user.setUsername(username);
		user.setAddress(address);

		boolean b = userdaoServiceInter.insertUser(user);

		if (b == true) {
			return SUCCESS;
		} else
			return INPUT;
	}

	public String loginUser() {
		System.out.println("登陆=======");

		String name = this.name;
		String password = this.password;

		User user = userdaoServiceInter.querybyname(name);

		if (user != null && password.equals(user.getPassword())) {
			this.username = user.getUsername();
			return SUCCESS;
		} else
			return ERROR;
	}
}
