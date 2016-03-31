package com.tch.test.spring_mvc_mybatis.dao.user;

import java.util.List;

import com.tch.test.spring_mvc_mybatis.model.user.User;

public interface UserMapper {

	/**
	 * 查询全部user
	 * @return
	 */
	List<User> getAllUsers();

}
