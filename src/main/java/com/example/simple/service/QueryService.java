package com.example.simple.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.simple.entity.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxu on 2017/12/22.
 * RestTemplate配置类
 */
@Configuration
public class QueryService {

    @Autowired
    private RestTemplate restTemplate;

    public String queryHttp(String url){
        try{
            String json = restTemplate.getForObject(url, String.class);

            json=json.substring(json.indexOf('(')+1,json.lastIndexOf(')'));

            JSONObject object = JSONObject.parseObject(json);

            Object data = object.get("data");

            Map<String,String> stringStringMap = (Map<String,String>)JSON.parse(data+"");


            List<Seed> list = new ArrayList<>();

            for (String s : stringStringMap.keySet()) {
                System.out.println(s + "==>" +stringStringMap.get(s));

            }



            String result = new String(json.getBytes("UTF-8"), "UTF-8");

            System.out.println(result);
            return json;
        }catch (Exception e){

        }
        //get json数据
        return "";

    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}