package com.union.construction_web.config;

import com.union.construction_web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //.addPathPatterns("/**");             // Interceptor 적용 대상
                .excludePathPatterns("/js/**", "/css/**", "/images/**", "/error", "/favicon.ico");     // Interceptor 적용대상 아님. (List를 통해서 경로 설정 가능)
    }
}
