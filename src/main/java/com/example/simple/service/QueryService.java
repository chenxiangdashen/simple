package com.example.simple.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.simple.entity.Movie;
import com.example.simple.entity.Seed;
import com.example.simple.mapper.MoiveRepository;
import com.example.simple.mapper.SeedRepository;
import com.example.simple.utils.QueryUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Configuration
public class QueryService {

    @Autowired
    private SeedRepository seedRepository;

    @Autowired
    private QueryUrl queryUrl;


    @Autowired
    private MoiveRepository moiveRepository;

    public void queryHttp(){
        List<Movie> movieList = moiveRepository.findAll();

        for (int i = 0 ; i<movieList.size(); i ++ ){
            String url = "http://api.xhub.cn/api.php?op=search_list&callback=jQuery19106557464973455058_1524145409076&key="+movieList.get(i).getTitle()+"&page=1&code=9d7196f4e8cb8dce1915624467f2f89b&_=1524145409077";
            try{
                String json = queryUrl.queryUrl(url);
                System.out.println(json);
                json=json.substring(json.indexOf('(')+1,json.lastIndexOf(')'));
                JSONObject object = JSONObject.parseObject(json);
                Object data = object.get("data");
                Map<String,JSONObject> stringStringMap = (Map<String,JSONObject>)JSON.parse(data+"");
                List<Seed> list = new ArrayList<>();
                for (String s : stringStringMap.keySet()) {
                    Seed seed = JSON.parseObject(stringStringMap.get(s)+"",Seed.class);
                    seedRepository.save(seed);
                    list.add(seed);
                }

            }catch (Exception e){
                System.out.println(e.toString());

            }
        }

    }
}