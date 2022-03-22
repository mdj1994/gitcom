package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OptionController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER.key}")
    private String API_SERVER;


    /**
     * 신문고 리스트
     * @return
     */
    @GetMapping("/option/option_list.do")
    public String option_list() {

        return "option/option_list";
    }

    /**
     * 신문고 상세 정보
     * @return
     */
    @GetMapping("/option/option_detail.do")
    public String option_detail() {

        return "option/option_detail";
    }

}
