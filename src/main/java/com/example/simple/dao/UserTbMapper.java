package com.example.simple.dao;

import com.example.simple.core.universal.Mapper;
import com.example.simple.entity.UserTb;

public interface UserTbMapper extends Mapper<UserTb> {
    UserTb findByUsername(String username);

    UserTb findUserById(String id);
}