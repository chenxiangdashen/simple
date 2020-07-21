package com.example.simple.controller;

import com.example.simple.core.aop.AnnotationLog;
import com.example.simple.core.ret.RetResponse;
import com.example.simple.core.ret.RetResult;
import com.example.simple.entity.Movie;
import com.example.simple.service.DoubanMoiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"豆瓣电影操作接口"}, description = "DoubanMovieController")
public class DoubanMovieController {


    @Resource
    private DoubanMoiveService doubanMoiveService;

    @ApiOperation(value = "查询热门电影", notes = "查询所有热门电影")
    @RequestMapping(value = "/queryHotMove",method=RequestMethod.GET)
    @AnnotationLog(remark = "查询")
    public RetResult<Object> query (){
        List<Movie> list = doubanMoiveService.queryHotMovie();
        return RetResponse.makeOKRsp(list);
    }

    @RequestMapping(value = "/queryAllHot",method=RequestMethod.GET)
    public String queryAll (){
        return doubanMoiveService.queryAllMoive();
    }


    public void saveNewHotMoive(){
        doubanMoiveService.saveNewHotMoive("https://movie.douban.com/cinema/nowplaying/shanghai/");
    }


}
