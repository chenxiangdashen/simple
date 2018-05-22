package com.example.simple.controller;

import com.example.simple.service.DoubanMoiveService;
import com.example.simple.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoubanMovieController {


    @Autowired
    private DoubanMoiveService doubanMoiveService;

    @RequestMapping("/queryHotMove")
    public String query (){
        return doubanMoiveService.queryHotMovie();
    }

    @RequestMapping("/queryAllHot")
    public String queryAll (){
        return doubanMoiveService.queryAllMoive();
    }


}
