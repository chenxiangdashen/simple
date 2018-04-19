package com.example.simple.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryMapper {
    JSONObject query(String url);
}
