package com.example.simple.vo;

import com.example.simple.entity.Movie;
import com.example.simple.entity.Seed;

import java.util.List;

public class MoiveVo extends Movie {

    private List<Seed> seedList;

    public List<Seed> getSeedList() {
        return seedList;
    }

    public void setSeedList(List<Seed> seedList) {
        this.seedList = seedList;
    }
}
