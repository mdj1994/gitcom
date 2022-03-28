package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SinmungoController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();


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
    public String sinmungo_detail(@RequestParam(value="idx", required = false) int idx
    , Model model) {

        log.info(String.valueOf(idx));
        model.addAttribute("idx", idx);



        return "sinmungo/sinmungo_detail";
    }

    /**
     * 신문고 비밀글 여부
     * @return
     */
    @GetMapping("/sinmungo/sinmungo_secrit_detail.do")
    public String sinmungo_detail(@RequestParam(value="idx", required = false) int idx
                                  ,@RequestParam(value="secrit", required = false) String secrit
                                  ,HttpServletRequest request) {

        request.getSession().setAttribute("last_passwd", secrit);


        return "redirect:/sinmungo/sinmungo_detail.do?idx="+idx;
    }

    /**
     * 신문고 글쓰기 - 로그인여부 파악하기
     * @return
     */
    @GetMapping("/sinmungo/sinmungo_write.do")
    public String sinmungo_write(HttpServletRequest request) {

        String result = "1";        //0 성공, 1 실패
        request.getSession().setAttribute("last_passwd", "0");

        if(request.getSession().getAttribute("member") != null) {
            return "sinmungo/sinmungo_write";
        } else {
            return "redirect:/main/login.do";
        }
    }


    @GetMapping("/sinmungo/sinmungo_update.do")
    public String sinmungo_update(@RequestParam(value="idx", required = false) String idx,
                                  HttpServletRequest request,
                                  Model model) {

        model.addAttribute("idx", String.valueOf(idx));

        if(request.getSession().getAttribute("member") != null) {
            return "sinmungo/sinmungo_update";
        } else {
            return "redirect:/main/login.do";
        }

    }
}
