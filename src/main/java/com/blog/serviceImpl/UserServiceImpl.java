package com.blog.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.model.User;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public String login(String name, String password) {
		if(userRepository.findByNameAndPassword(name, password) != null){
			return "登录成功！";
		}
		return "登录失败";
	}
	@Override
	public String register(String name, String email, String password) {
		userRepository.save(new User(name, email, password));
		return "注册成功！";
	}
}
