package com.tch.test.spring_mvc_mybatis.datasource;

import org.aspectj.lang.ProceedingJoinPoint;

public class ChooseDataSource {

	public Object determineReadOrWriteDB(ProceedingJoinPoint pjp) throws Throwable {
		
		JdbcContextHolder.setSlave();
		try {
			return pjp.proceed();
		} finally {
			JdbcContextHolder.setMaster();
		}

	}
}
