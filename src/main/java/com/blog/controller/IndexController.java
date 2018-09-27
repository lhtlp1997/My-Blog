package com.blog.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Time 2018-4-20
 * @author 刘瀚霆
 * @email 396882678@qq.com
 */
@Controller
public class IndexController {
	
	@GetMapping("/")
	public String get(){
		return "index";
	}
	
}
