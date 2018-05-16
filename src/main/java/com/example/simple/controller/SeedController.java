package com.example.simple.controller;

import com.example.simple.service.DoubanMoiveService;
import com.example.simple.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeedController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/query")
    public void query (){
         queryService.queryHttp();
    }

}
