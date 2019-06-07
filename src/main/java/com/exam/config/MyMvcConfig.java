package com.exam.config;

import com.exam.component.AdminLoginHandlernterceptor;
import com.exam.component.UserLoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fang
 * @date 2019/1/17 0017 - 上午 9:38
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/user/main").setViewName("user/main");
        registry.addViewController("/user/complete").setViewName("user/complete");
        registry.addViewController("/admin").setViewName("admin/admin");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginHandlerInterceptor()).addPathPatterns("/user/**");

        registry.addInterceptor(new AdminLoginHandlernterceptor()).addPathPatterns("/admin/**");

    }



}
