package com.example.simple.service;

import com.example.simple.core.universal.Service;
import com.example.simple.entity.Danmu;

import java.util.List;


public interface DanmuServiceNew extends Service<Danmu> {

    List<Danmu> selectAlla(int pageNum, int pageSize);

}