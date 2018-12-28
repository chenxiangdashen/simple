package com.example.simple;

import com.example.simple.controller.DanmuController;
import com.example.simple.controller.DoubanMovieController;
import org.mybatis.spring.annotation.MapperScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@MapperScan("com.example.simple.mapper")
@Configuration
@SpringBootApplication
@Component
@SpringBootConfiguration
@EnableScheduling
public class SimpleApplication extends SpringBootServletInitializer implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleApplication.class);
    //
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SimpleApplication.class);
    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SimpleApplication.class, args);
//    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(SimpleApplication.class, args);


//        SpringApplication app = new SpringApplication(SimpleApplication.class);
//        Environment env = app.run(args).getEnvironment();
//        LOGGER.info("\n----------------------------------------------------------\n\t" +
//                        "Application '{}' is running! Access URLs:\n\t" +
//                        "Local: \t\thttp://localhost:{}\n\t" +
//                        "External: \thttp://{}:{}\n\t" +
//                        "Profile(s): \t{}\n----------------------------------------------------------",
//                env.getProperty("spring.application.name"),
//                env.getProperty("server.port"),
//                InetAddress.getLocalHost().getHostAddress(),
//                env.getProperty("server.port"),
//                env.getActiveProfiles());
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(new WebAppConfig());
//    }
////
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedHeaders("*")
//                .allowedOrigins("*")
//                .allowedMethods("*");
//
//    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

    @Autowired
    DoubanMovieController doubanMovieController;

    @Autowired
    DanmuController danmuController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位

        danmuController.saveDanmu();

//        service.scheduleAtFixedRate(()->{
//            System.out.println("task ScheduledExecutorService "+new Date());
//            doubanMovieController.saveNewHotMoive();
//        }, 0, 3, TimeUnit.DAYS);


    }
}
