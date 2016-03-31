package com.tch.test.spring_mvc_mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.tch.test.spring_mvc_mybatis.model.User;

@RequestMapping("/userController")
public class UserController {

	@RequestMapping("/index")
	public String index(){
		
		return "velocity/index.vm";
	}
	
	@RequestMapping("/index")
	public User getUser(User user){
		
		return "velocity/index.vm";
	}
	
}
