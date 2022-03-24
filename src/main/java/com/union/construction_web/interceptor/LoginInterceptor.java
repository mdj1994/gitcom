package com.union.construction_web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws  Exception {

        log.info("============= construction_web =============");
        log.info("Request URI ==>  :"+request.getRequestURI());
        log.info("============================================");


        //response.sendRedirect("/");

        return true;
        //return super.preHandle(request, response, handle);
    }
}
