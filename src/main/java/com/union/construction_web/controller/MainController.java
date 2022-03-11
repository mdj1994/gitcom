package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.union.construction_web.domain.TestBean;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController extends BaseController {

    ObjectMapper objectMapper = new ObjectMapper();

    @Value("${API_SERVER.key}")
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
}
