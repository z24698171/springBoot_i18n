package com.liuhailong.springboot_i18n.config;

import com.liuhailong.springboot_i18n.common.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMvcConfig
 * @Description
 * @Author Liuhailong
 * @Date 2019/12/20 15:01
 **/
@Configuration
    public class MyMvcConfig implements WebMvcConfigurer {

    /*等同于controller中返回视图 return "/login.html"*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
}
