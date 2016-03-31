package com.tch.test.spring_mvc_mybatis.model;

import java.util.Date;

import lombok.Data;

@Data
public class User{

	private Integer id;
	private Integer age;
    private String username;
    private String password;
    private Date updateTime;
    
}
