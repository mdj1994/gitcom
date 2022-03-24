package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.TestBean;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:message/properties.properties")
public class MainController extends BaseController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER}")
    private String API_SERVER;


    @GetMapping("/test123")
    public void test() {

        try {
            TestBean testBean = new TestBean();
            testBean.setT_NAME("가나다라");

            System.out.println(testBean.getT_NAME());
            String jsonString = objectMapper.writeValueAsString(testBean);
            JSONObject jsonObject = sendPost(API_SERVER+"/test_api", jsonString);

            System.out.println(jsonObject);

        } catch (Exception e) {
            System.out.println("catch");
        }

    }


    @GetMapping("/testPage")
    public String testPage01() {

        try {

        }
        catch (Exception e) {

        }

        return "test/test01";
    }

    @GetMapping("/main/login.do")
    public String login() {

        try {
            log.info("======== /login.do");
        }
        catch (Exception e) {

        }

        return "login";
    }


    @GetMapping("/")
    public String default_html() {

        log.info("/test");

        return "login";
    }

    @GetMapping("/main/main.do")
    public String Main() {

        log.info("main.do");

        return "main/main";
    }

    @GetMapping("/layout")
    public String test_Layout() {

        return "layout/noMenu";
    }

    @GetMapping("/layout_test")
    public String test_Layout02() {

        return "member/content2";
    }

    @GetMapping("/layout2")
    public String test_layout03() {

        return "layout/default_layout";
    }
}
