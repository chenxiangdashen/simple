package com.example.simple.controller;

import com.alibaba.fastjson.JSON;
import com.example.simple.entity.User;
import com.example.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/helloUser/{id}")
    public String selectUser (@PathVariable int id){
        User user = userService.selectUser(id);

        return JSON.toJSONString(user);

    }
}