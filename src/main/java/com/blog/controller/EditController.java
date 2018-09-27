package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.model.Blog;
import com.blog.repository.BlogRepository;

//
@Controller
public class EditController {
	
	private final BlogRepository blogRepository;
	
	@Autowired
	public EditController(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	@GetMapping("/edit")
	public String editGet(){
		return "edit";
	}
	
	@PostMapping("/edit")
	public String editPost(@RequestParam String title,@RequestParam String content){
		Blog blog = new Blog(title, content);
		blogRepository.save(blog);
		return "single";
	}
}
