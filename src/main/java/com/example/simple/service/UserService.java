package com.example.simple.service;

import com.example.simple.entity.User;
import com.example.simple.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }
}
