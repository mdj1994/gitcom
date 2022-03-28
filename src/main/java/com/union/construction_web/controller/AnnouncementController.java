package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnouncementController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 공개제안 글 목록
     *
     * @return
     */
    @GetMapping("/announcement/announcement_list.do")
    public String announcement_list() {


        return "announcement/announcement_list";
    }

    @GetMapping("/announcement/announcement_detail.do")
    public String announcement_detail() {

        return "announcement/announcement_detail";
    }


}
