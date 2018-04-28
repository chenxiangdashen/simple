package com.example.simple.service;

import com.example.simple.entity.Movie;
import com.example.simple.mapper.MoiveRepository;
import com.example.simple.utils.QueryUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class DoubanMoiveService {

    @Autowired
    private QueryUrl queryUrl;

    @Autowired
    private MoiveRepository moiveRepository;

    public String queryHotMoive(String url){
        String json = queryUrl.queryUrl(url);
//        json = json.replaceAll("\n", "");
        StringBuilder lastInfo=new StringBuilder();


        Document doc = Jsoup.parse(json);
        Elements rows = doc.select("div[id=nowplaying] .mod-bd").select(".lists >li");
        if (rows.size() == 1) {
            System.out.println("没有结果");
        }else {

            for (int i =0;i< rows.size();i++){
                Movie movie= new Movie();
                Element row = rows.get(i);
                movie.setTitle(row.attr("data-title"));
                movie.setActors(row.attr("data-actors"));
                movie.setDirector(row.attr("data-director"));
                movie.setDuration(row.attr("data-duration"));
                movie.setRelease(row.attr("data-release"));
                movie.setScore(Integer.parseInt(row.attr("data-score")));
                movie.setStar(Integer.parseInt(row.attr("data-star")));
                moiveRepository.save(movie);
                System.out.println(movie);
            }



        }
        return json;
    }
}
