package com.example.simple;

import com.example.simple.controller.DoubanMovieController;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@MapperScan("com.example.simple.mapper")
@Configuration
@SpringBootApplication
@Component
@EnableScheduling
public class SimpleApplication extends WebMvcConfigurerAdapter implements ApplicationRunner {

//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SimpleApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SimpleApplication.class, args);
//    }

    public static void main(String[] args) { SpringApplication.run(SimpleApplication.class, args);}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new WebAppConfig());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");

    }

    @Autowired
    DoubanMovieController doubanMovieController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(()->{
            System.out.println("task ScheduledExecutorService "+new Date());
            doubanMovieController.query();
        }, 0, 3, TimeUnit.DAYS);


    }
}
