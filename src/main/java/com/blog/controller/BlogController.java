package com.blog.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.repository.BlogRepository;

@Controller
public class BlogController {
	
	private final BlogRepository blogRepository;
	
	private Long id;
	
	@Autowired
	public BlogController(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	/**
	 * 重要问题！！！！！！
	 * 我们访问的single.html网页，如果采用的是二级链接，比如/blog/{id}，这样形式的，所有的css，js图片等都加载不出来
	 * 原因暂时还没有找到！！！
	 */
	@GetMapping("/{id}")
	public String get(@PathVariable Long id){
		this.id = id;
		return "single";
	}
	
	@GetMapping("/blog/content")
	@ResponseBody
	public HashMap<String, String> getContent(){
		String content = blogRepository.findOne(this.id).getContent();
		HashMap<String, String> map = new HashMap<>();
		map.put("content", content);
		return map;
	}
	
	
}
