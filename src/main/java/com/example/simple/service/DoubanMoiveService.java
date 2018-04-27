package com.example.simple.service;

import com.example.simple.utils.QueryUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class DoubanMoiveService {

    @Autowired
    private QueryUrl queryUrl;

    public String queryHotMoive(String url){
        String json = queryUrl.queryUrl(url);
//        json = json.replaceAll("\n", "");
        StringBuilder lastInfo=new StringBuilder();


        Document doc = Jsoup.parse(json);
        Elements rows = doc.select("div[id=nowplaying] .mod-bd").select(".lists >li");
        if (rows.size() == 1) {
            System.out.println("没有结果");
        }else {


            System.out.println("--------------------------- 查询结果 ---------------------------");

        }
        return json;
    }
}
