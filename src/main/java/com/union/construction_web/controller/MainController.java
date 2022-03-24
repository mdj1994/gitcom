package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.TestBean;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource("classpath:message/properties.properties")
public class MainController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER}")
    private String API_SERVER;

    /**
     * PC 시작값
     * @return
     */
    @GetMapping("/")
    public String default_html() {

        log.info("/test");

        return "main/main";
    }


    /**
     * logout
     * @param request
     * @return
     */
    @GetMapping("/main/logout.do")
    public String logout(HttpServletRequest request) {

        //세션 지우기
        request.getSession().invalidate();

        return "main/main";
    }


    /**
     * loggin 창
     * @return
     */
    @GetMapping("/main/login.do")
    public String login() {

        try {
        }
        catch (Exception e) {

        }

        return "login";
    }


    /**
     * main 이동
     * @return
     */
    @GetMapping("/main/main.do")
    public String Main() {


        return "main/main";
    }
}
