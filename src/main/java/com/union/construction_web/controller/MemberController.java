package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PropertySource("classpath:message/properties.properties")
public class MemberController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER}")
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
    public String membership02(@RequestParam(value="mobile_no") String mobile_no,
                               @RequestParam(value="user_nm") String user_nm, Model model) {

        try {

            model.addAttribute("mobile_no", mobile_no);
            model.addAttribute("user_nm", user_nm);

        }
        catch (Exception e) {
            log.error("정상적인 방법이 아닙니다.");
        }

        return "member/membership02";
    }

    /**
     * 회원가입2
     * @return
     */
    @GetMapping("/member/membership03.do")
    public String membership03(Member member, Model model) {

        try {

            log.info("name : "+member.getMember_nm());
            log.info("mobile no : "+member.getMobile_no());

            model.addAttribute("mobile_no", member.getMobile_no());
            model.addAttribute("member_nm", member.getMember_nm());


        }
        catch (Exception e) {

        }

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
