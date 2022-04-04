package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnnouncementController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 공지사항 글 목록
     *
     * @return
     */
    @GetMapping("/announcement/announcement_list.do")
    public String announcement_list() {


        return "announcement/announcement_list";
    }


    /**
     * 공지사항 detail
     * @return
     */
    @GetMapping("/announcement/announcement_detail.do")
    public String announcement_detail(@RequestParam(value="idx") String idx, Model model) {

        model.addAttribute("idx", idx);

        return "announcement/announcement_detail";
    }


}
