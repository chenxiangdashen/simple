package com.example.simple.service;

import com.alibaba.fastjson.JSON;
import com.example.simple.entity.Movie;
import com.example.simple.entity.Seed;
import com.example.simple.mapper.MoiveRepository;
import com.example.simple.mapper.SeedRepository;
import com.example.simple.utils.QueryUrl;
import com.example.simple.utils.SortDto;
import com.example.simple.utils.SortTools;
import com.example.simple.vo.MoiveVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class DoubanMoiveService {

    @Autowired
    private QueryUrl queryUrl;

    @Autowired
    private MoiveRepository moiveRepository;

    @Autowired
    private SeedRepository seedRepository;


    public String saveNewHotMoive(String url) {

        //先删除 表里所有数据
        moiveRepository.deleteAll();
        seedRepository.deleteAll();

        String json = queryUrl.queryUrl(url);
        Document doc = Jsoup.parse(json);
        List<Movie> list = new ArrayList<>();
        Elements rows = doc.select("div[id=nowplaying] .mod-bd").select(".lists >li");
        if (rows.size() == 1) {
            System.out.println("没有结果");
        } else {

            for (int i = 0; i < rows.size(); i++) {
                Movie movie = new Movie();
                Element row = rows.get(i);
                movie.setMovieID(row.attr("id"));
                movie.setTitle(row.attr("data-title"));
                movie.setActors(row.attr("data-actors"));
                movie.setDirector(row.attr("data-director"));
                movie.setDuration(row.attr("data-duration"));
                movie.setReleaseTime(row.attr("data-release"));
                movie.setScore(row.attr("data-score"));
                movie.setVotecount(Integer.parseInt(row.attr("data-votecount")));
                movie.setRegion(row.attr("data-region"));
                movie.setStar(Integer.parseInt(row.attr("data-star")));
                movie.setImageSrc(row.select("img").attr("src"));
                list.add(movie);

                queryItemByA(movie.getTitle(),movie.getMovieID());
                moiveRepository.save(movie);
            }
        }
        return json;
    }

    /**
     * 查询所有热们电影
     *
     * @return
     */
    public String queryAllMoive() {
        List<MoiveVo> result = new ArrayList<>();
        List<Movie> list = moiveRepository.findAll(SortTools.basicSort(new SortDto("desc", "votecount")));
        for(int i=0;i<list.size(); i ++) {
            Movie movie = list.get(i);
            MoiveVo moiveVo = new MoiveVo();

            List<Seed> seedList = seedRepository.findbyMoiveID(movie.getMovieID());
            moiveVo.setSeedList(seedList);
            moiveVo.setMovieID(movie.getMovieID());
            moiveVo.setActors(movie.getActors());
            moiveVo.setDirector(movie.getDirector());
            moiveVo.setDuration(movie.getDuration());
            moiveVo.setImageSrc(movie.getImageSrc());
            moiveVo.setRegion(movie.getRegion());
            moiveVo.setReleaseTime(movie.getReleaseTime());
            moiveVo.setScore(movie.getScore());
            moiveVo.setTitle(movie.getTitle());
            moiveVo.setVotecount(movie.getVotecount());
            moiveVo.setSubject(movie.getSubject());

            result.add(moiveVo);

            System.out.println(seedList.toString());


        }


        return JSON.toJSONString(result);
    }

    private void queryItemByA(String name , String moiveID) {
//        String url= "https://btcat.org/search/"+name+"/default-1.html";
        String url= "https://m.zhongziso.com/list/" + name + "/1";
        String json = queryUrl.queryUrl(url);
        Document doc = Jsoup.parse(json);
        List<Seed> list = new ArrayList<>();
        Elements rows = doc.select(".panel-body").select(".list-group");

        if (rows.size() == 0) {
            System.out.println("没有结果");
        } else {

            for (int i = 0; i < rows.size(); i++) {
                Element row = rows.get(i);
                Seed seed = new Seed();
                seed.setTitle(name);
                seed.setUrl(row.select(".btn-success").attr("href"));
                seed.setDay(row.select(".text-time").text());
                seed.setSize(row.select(".text-size").text());
                seed.setCreateDate(new Date());
                seed.setHits(0);
                seed.setMoiveID(moiveID);
                seedRepository.save(seed);
            }
        }
    }
}


