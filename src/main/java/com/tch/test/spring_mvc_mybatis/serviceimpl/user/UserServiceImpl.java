package com.tch.test.spring_mvc_mybatis.serviceimpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tch.test.spring_mvc_mybatis.dao.user.UserMapper;
import com.tch.test.spring_mvc_mybatis.model.user.User;
import com.tch.test.spring_mvc_mybatis.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
	
}
