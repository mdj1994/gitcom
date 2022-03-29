package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OptionController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 신문고 리스트
     * @return
     */
    @GetMapping("/opinion/opinion_list.do")
    public String option_list() {

        return "opinion/opinion_list";
    }

    /**
     * 신문고 상세 정보
     * @return
     */
    @GetMapping("/opinion/opinion_detail.do")
    public String option_detail(@RequestParam(value="idx") String idx, Model model) {

        model.addAttribute("idx", idx);

        return "opinion/opinion_detail";
    }

}
