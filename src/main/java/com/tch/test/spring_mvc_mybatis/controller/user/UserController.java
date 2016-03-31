package com.tch.test.spring_mvc_mybatis.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tch.test.spring_mvc_mybatis.model.user.Person;
import com.tch.test.spring_mvc_mybatis.model.user.User;
import com.tch.test.spring_mvc_mybatis.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/userController")
public class UserController {
	 
	@Autowired
	private UserService userService;

	@RequestMapping("/jspIndex")
	public String jspIndex(HttpServletRequest request, Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "user/jspIndex";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "user/index";
	}
	
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	/**
	 * 保存复杂对象
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveComplexObj")
	public String saveComplexObj(HttpServletRequest request, Model model){
		return "user/saveComplexObj";
	}
	
	/**
	 * 展示保存的负责对象
	 * @param model
	 * @param paramStr
	 * @return
	 */
	@RequestMapping("/addPerson")
    public String addPerson(Model model, @RequestParam("paramStr") String paramStr) {
	    Person person = JSON.parseObject(paramStr, Person.class);
        log.info("person:{}", person);
        model.addAttribute("person", person);
        return "user/showPerson";
    }
	
}
