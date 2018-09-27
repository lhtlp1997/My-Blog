package com.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blog.form.RegisterForm;
import com.blog.model.User;
import com.blog.service.UserService;

/**
 * @Time 2018-4-20
 * @author 刘瀚霆
 * @Emial 396882678@qq.com
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private final UserService userService;
	
	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String get(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping
	public String post(Model model,@ModelAttribute("user") @Valid RegisterForm form,
						BindingResult result,final RedirectAttributes attributes){
		//表单验证
		//表单验证的话，直接return html就可以，不用FlashRedirectAttributes
		if(result.hasErrors()){
			model.addAttribute("fields", result);
			return "register";
		}
		
		//表单验证结束，直接注册就可以了
		User user = form.toUser();
		String message = userService.register(user.getName(), user.getEmail(), user.getPassword());
		attributes.addFlashAttribute("message", message);
		if("注册成功！".equals(message)){
			return "redirect:/" + "login";

		}else {
			return "redirect:/" + "register";
		}
	}
}
