package com.tch.test.spring_mvc_mybatis.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tch.test.spring_mvc_mybatis.model.common.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Response exceptionHandler(Exception ex,HttpServletRequest request,HttpServletResponse response) {
        log.error(ex.getMessage(), ex);
        return new Response(10000001,"服务器异常");
    }

    @ExceptionHandler
    @ResponseBody
    public Response exceptionHandler(HttpMediaTypeNotSupportedException ex) {
    	log.error(ex.getMessage(), ex);
        return new Response(10000002,"参数转换异常");
    }
}