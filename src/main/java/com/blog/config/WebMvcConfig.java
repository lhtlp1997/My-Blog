package com.blog.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.blog.interceptor.LoginInterceptor;

public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	//配置Interceptor
	//这里配置的就是需要进行预处理的web请求，/**表示对之前的链接下的所有URL进行检查
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/");
	}

}
