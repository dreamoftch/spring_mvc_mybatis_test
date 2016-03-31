package com.tch.test.spring_mvc_mybatis.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return JdbcContextHolder.getJdbcType();
	}

}
