package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JeanController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 공개제안 글 목록
     * @return
     */
    @GetMapping("/jean/jean_list.do")
    public String jean_list() {


        return "jean/jean_list";
    }

    @GetMapping("/jean/jean_detail.do")
    public String jean_detail() {

        return "jean/jean_detail";
    }


    /**
     * 공개제안 글쓰기
     * @return
     */
    @GetMapping("/jean/jean_write.do")
    public String jean_write() {

        return "jean/jean_write";
    }


}
