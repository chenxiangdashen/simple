package com.example.simple.controller;

import com.example.simple.common.util.ResultUtil;
import com.example.simple.core.entity.RegionCityEntity;
import com.example.simple.core.service.RegionCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始页面
 * @Author Sans
 * @CreateTime 2019/10/2 15:11
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @Autowired
    private RegionCityService regionCityService;
    /**
     * 首页
     * @Author Sans
     * @CreateTime 2019/10/2 15:23
     * @Return Map<String,Object> 返回数据MAP
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        // 组装参数
        Map<String,Object> result = new HashMap<>();
        result.put("title","这里是首页不需要权限和登录拦截");
        return ResultUtil.resultSuccess(result);
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> regionInfo(){
        // 组装参数
        Map<String,Object> result = new HashMap<>();
        List<RegionCityEntity> list= regionCityService.list();

        result.put("data",list);
        return ResultUtil.resultSuccess(result);
    }

}
