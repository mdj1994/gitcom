package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.Member;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@PropertySource("classpath:message/properties.properties")
public class MemberController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER}")
    private String API_SERVER;



    @PostMapping("/member/loginAction.do")
    @ResponseBody
    public String loginAction(Member member, HttpServletRequest request) {

        JSONObject jsonObject = new JSONObject();
        String result = "-1";

        try {

            String jsonString = objectMapper.writeValueAsString(member);
            //API 호출로 값 가져오기
            jsonObject = sendPost(API_SERVER + "/user/member/loginAction.ajax", jsonString);

            //API 결과값이 0일 경우, 성공
            if(jsonObject.get("RST_CD").toString().equals("0")) {

                HttpSession session = request.getSession();
                session.setAttribute("member", member);  //login data를 session에 저장
                session.setAttribute("login", true);

            }
        }
        catch(Exception e) {

        }

        return jsonObject.get("RST_CD").toString(); //결과값을 그대로 web에 전달
    }


    /**
     * 회원가입(id, 핸드폰번호 받기)
     * @return
     */
    @GetMapping("/member/membership01.do")
    public String membership01() {

        return "member/membership01";
    }

    /**
     * 회원가입2(인증번호 입력받기)
     * @return
     */
    @GetMapping("/member/membership02.do")
    public String membership02(Member member, Model model) {

        try {

            model.addAttribute("result", member);

        }
        catch (Exception e) {
            log.error("정상적인 방법이 아닙니다.");
        }

        return "member/membership02";
    }

    /**
     * 회원가입2(비밀번호 받기)
     * @return
     */
    @GetMapping("/member/membership03.do")
    public String membership03(Member member, Model model) {

        try {

            log.info("member_id : "+member.getMember_id());
            log.info("name : "+member.getMember_nm());
            log.info("mobile no : "+member.getMobile_no());

            model.addAttribute("result", member);

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
