package com.union.construction_web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {

        log.info("============= construction_web =============");
        log.info("Request URI ==>  :" + request.getRequestURI());
        log.info("============================================");

        String context = request.getContextPath();  //path 설정 시 값 생성
        String url = request.getRequestURI().substring(context.length() + 1); //해당 url에서 설정된 path 있을 시 제거. +1
        String nav = "main";
        if (!(url.length() <= 1)) {
            System.out.println(url);
            nav = url.substring(0, url.indexOf("/"));

        }
        request.setAttribute("nav", nav);
        //response.sendRedirect("/");

        return true;
        //return super.preHandle(request, response, handle);
    }
}
