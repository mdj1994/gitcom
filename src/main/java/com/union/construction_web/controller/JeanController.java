package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JeanController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 공개제안 리스트
     * @return
     */
    @GetMapping("/jean/jean_list.do")
    public String jean_list() {

        return "jean/jean_list";
    }

    /**
     * 공개제안 상세 정보
     * @return
     */
    @GetMapping("/jean/jean_detail.do")
    public String jean_detail(@RequestParam(value="idx", required = false) int idx
            , Model model) {

        log.info(String.valueOf(idx));
        model.addAttribute("idx", idx);



        return "jean/jean_detail";
    }

    /**
     * 공개제안 비밀글 여부
     * @return
     */
    @GetMapping("/jean/jean_secrit_detail.do")
    public String jean_detail(@RequestParam(value="idx", required = false) int idx
            , @RequestParam(value="secrit", required = false) String secrit
            , HttpServletRequest request) {

        request.getSession().setAttribute("last_passwd", secrit);


        return "redirect:/jean/jean_detail.do?idx="+idx;
    }

    /**
     * 공개제안 글쓰기 - 로그인여부 파악하기
     * @return
     */
    @GetMapping("/jean/jean_write.do")
    public String jean_write(HttpServletRequest request) {

        String result = "1";        //0 성공, 1 실패
        request.getSession().setAttribute("last_passwd", "0");

        if(request.getSession().getAttribute("member") != null) {
            return "jean/jean_write";
        } else {
            return "redirect:/main/login.do";
        }
    }


    /**
     * 공개제안 수정하기 - update 유무 파악하기
     * @param idx
     * @param request
     * @param model
     * @return
     * idx : update page 넘기면서 필요한  jean_no 값
     */
    @GetMapping("/jean/jean_update.do")
    public String jean_update(@RequestParam(value="idx", required = false) String idx,
                                  HttpServletRequest request,
                                  Model model) {

        model.addAttribute("idx", String.valueOf(idx));

        if(request.getSession().getAttribute("member") != null) {
            return "jean/jean_update";
        } else {
            return "redirect:/main/login.do";
        }

    }

}
