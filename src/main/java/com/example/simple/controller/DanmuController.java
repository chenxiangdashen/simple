package com.example.simple.controller;

import com.example.simple.service.DanmuService;
import com.example.simple.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DanmuController {

    @Autowired
    DanmuService danmuService;

    public void saveDanmu(){
        danmuService.saveDanmu();
    }
}
