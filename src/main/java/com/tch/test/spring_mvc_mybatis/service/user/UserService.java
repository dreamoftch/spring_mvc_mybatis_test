package com.tch.test.spring_mvc_mybatis.service.user;

import java.util.List;

import com.tch.test.spring_mvc_mybatis.model.User;

public interface UserService {

	/**
	 * 查询全部user
	 * @return
	 */
	List<User> getAllUsers();
	
}
