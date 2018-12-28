package com.example.simple.controller;

import com.example.simple.core.ret.RetResponse;
import com.example.simple.core.ret.RetResult;
import com.example.simple.entity.Danmu;
import com.example.simple.service.DanmuService;
import com.example.simple.service.DanmuServiceNew;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"斗鱼弹幕"}, description = "DanmuController")
public class DanmuController {

    @Autowired
    DanmuService danmuService;


    @Resource
    DanmuServiceNew danmuServiceNew;

    public void saveDanmu(){
        danmuService.saveDanmu();
    }



    @RequestMapping(value = "/queryAllDanmu",method=RequestMethod.GET)
    public  RetResult<PageInfo<Danmu>>  query (){
        PageHelper.startPage(1, 20);
        List<Danmu> list = danmuServiceNew.selectAll();
        PageInfo<Danmu> pageInfo = new PageInfo<>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }

}
