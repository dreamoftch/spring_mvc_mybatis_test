package com.tch.test.spring_mvc_mybatis.model.user;

import java.util.List;

import lombok.Data;

@Data
public class Person {

    private String name;
    
    private String age;
    
    private List<Person> parents;
    
}
