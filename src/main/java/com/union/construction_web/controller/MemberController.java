package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.TestBean;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER.key}")
    private String API_SERVER;


    /**
     * 회원가입
     * @return
     */
    @GetMapping("/member/membership01.do")
    public String membership01() {

        return "member/membership01";
    }

    /**
     * 회원가입2
     * @return
     */
    @GetMapping("/member/membership02.do")
    public String membership02() {

        return "member/membership02";
    }

    /**
     * 회원가입2
     * @return
     */
    @GetMapping("/member/membership03.do")
    public String membership03() {

        return "member/membership03";
    }

    /**
     * 회원가입2
     * @return
     */
    @GetMapping("/member/membership04.do")
    public String membership04() {

        return "member/membership04";
    }
}
