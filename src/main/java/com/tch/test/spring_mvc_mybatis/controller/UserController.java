package com.tch.test.spring_mvc_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tch.test.spring_mvc_mybatis.model.User;
import com.tch.test.spring_mvc_mybatis.service.user.UserService;

@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model){
		model.addAttribute("user", userService.getAllUsers());
		return "velocity/index.vm";
	}
	
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
