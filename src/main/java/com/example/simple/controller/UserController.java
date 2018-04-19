package com.example.simple.controller;

import com.alibaba.fastjson.JSON;
import com.example.simple.entity.User;
import com.example.simple.service.QueryService;
import com.example.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private QueryService queryService;

    @RequestMapping("/helloUser/{id}")
    public String selectUser (@PathVariable int id){
        User user = userService.selectUser(id);

        return JSON.toJSONString(user);

    }


    @RequestMapping("/query/{key}")
    public String query (@PathVariable String key){
       return queryService.queryHttp("http://api.xhub.cn/api.php?op=search_list&callback=jQuery19106557464973455058_1524145409076&key="+key+"&page=1&code=9d7196f4e8cb8dce1915624467f2f89b&_=1524145409077");

    }





}
