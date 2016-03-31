package com.tch.test.spring_mvc_mybatis.serviceimpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tch.test.spring_mvc_mybatis.dao.user.UserMapper;
import com.tch.test.spring_mvc_mybatis.model.User;
import com.tch.test.spring_mvc_mybatis.service.user.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
	
}
