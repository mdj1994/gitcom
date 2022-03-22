package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinmungoController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER.key}")
    private String API_SERVER;


    /**
     * 신문고 리스트
     * @return
     */
    @GetMapping("/sinmungo/sinmungo_list.do")
    public String sinmungo_list() {

        return "sinmungo/sinmungo_list";
    }

    /**
     * 신문고 상세 정보
     * @return
     */
    @GetMapping("/sinmungo/sinmungo_detail.do")
    public String sinmungo_detail() {

        return "sinmungo/sinmungo_detail";
    }

    /**
     * 신문고 글쓰기
     * @return
     */
    @GetMapping("/sinmungo/sinmungo_write.do")
    public String sinmungo_write() {

        return "sinmungo/sinmungo_write";
    }
}
