package com.blog.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.form.LoginForm;
import com.blog.model.User;
import com.blog.service.UserService;

/**
 * @time 2018-4-20
 * @author Administrator
 * @Email 396882678@qq.com
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String get(Model model){
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping
	public String post(Model model,@ModelAttribute("user") @Valid LoginForm form,
						BindingResult result,HttpSession session,
						@RequestParam(value = "next", required = false) Optional<String> next,
						//这里@RequestParam默认是required = true,用户不一定勾选了remember me选项，故改为false
						@RequestParam(required = false) String[] remember){
		//表单验证
		if(result.hasErrors()){
			model.addAttribute("fields", result);
			return "login";
		}
		
		User user = form.toUser();
		String message = userService.login(user.getName(), user.getPassword());
		if("登录成功！".equals(message)){
			session.setAttribute("currentUser", user);
			//如果没有登录，返回到login界面
			return "redirect:".concat(next.orElse("/"));
		}
		
		//Cookie的部分先放着，项目其他地方完了再写
		
		return "login";
	}
	
	
	
	
	
	
}
