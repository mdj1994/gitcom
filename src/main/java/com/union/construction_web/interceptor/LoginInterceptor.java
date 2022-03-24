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

        System.out.println(request.getContextPath().length());

        log.info("============= construction_web =============");
        log.info("Request URI ==>  :"+request.getRequestURI());
        log.info("============================================");

        //member는 회원부분이므로 nav가 필요없다.
        if(request.getRequestURI().indexOf("/member/") < 0) {
            request.setAttribute("nav", false);
        } else {
            request.setAttribute("nav", true);
        }

        //response.sendRedirect("/");

        return true;
        //return super.preHandle(request, response, handle);
    }
}
