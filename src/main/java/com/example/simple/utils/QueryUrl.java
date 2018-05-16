package com.example.simple.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.simple.entity.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class QueryUrl {

    @Autowired
    private RestTemplate restTemplate;

    public String queryUrl(String url){
        try{
            HttpHeaders headers = new HttpHeaders();


            headers.set("Accept-Charset", "utf-8");
            headers.set("scheme", "https");
            headers.set("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            headers.set("accept-language", "zh-CN,zh;q=0.9");
            headers.set("cookie", "__cfduid=d70e5a3ffdf75871fff427485eefc200b1525112654; Hm_lvt_ea676c077d1fc50763a16160807c8822=1525112653,1526227096,1526314239; Hm_lpvt_ea676c077d1fc50763a16160807c8822=1526314239");
            headers.set("authority", "m.zhongziso.com");
            headers.set("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            JSONObject jsonObj =  new JSONObject();
            HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
//            String result = restTemplate.postForObject(url, formEntity, String.class);
            String result = restTemplate.postForObject(url, formEntity, String.class);

            return result;
        }catch (Exception e){
            System.out.println(e.toString());

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
        HttpHeaders headers = new HttpHeaders();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
