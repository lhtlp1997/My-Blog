package com.blog.service;

public interface UserService {

	/**
	 * 通过用户名和密码登录
	 * @param name
	 * @param password
	 * @return
	 */
	public String login(String name,String password);
	
	/**
	 * 注册
	 * @param name
	 * @param email
	 * @param password
	 * @return
	 */
	public String register(String name,String email,String password);
}
