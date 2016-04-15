package com.tch.test.spring_mvc_mybatis.utils.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.tch.test.spring_mvc_mybatis.controller.user.UserController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("注入ApplicationContext对象{}", applicationContext);
		ApplicationContextUtil.applicationContext = applicationContext;
		log.info("UserController {}", applicationContext.getBean(UserController.class));
	}
	
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}

}
