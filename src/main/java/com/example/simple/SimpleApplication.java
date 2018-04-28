package com.example.simple;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@MapperScan("com.example.simple.mapper")
@Configuration
@SpringBootApplication
@Component
public class SimpleApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) { SpringApplication.run(SimpleApplication.class, args);}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new WebAppConfig());
    }

}
