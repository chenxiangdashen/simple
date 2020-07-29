package com.example.simple.controller;

import com.example.simple.common.util.ResultUtil;
import com.example.simple.core.entity.RegionCityEntity;
import com.example.simple.core.service.RegionCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市区域
 * @Author Sans
 * @CreateTime 2019/10/2 15:11
 */
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionCityService regionCityService;

    /**
     * 首页
     * @Author Sans
     * @CreateTime 2019/10/2 15:23
     * @Return Map<String,Object> 返回数据MAP
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> getRegionList(@RequestParam String id){
        // 组装参数
        Map<String,Object> result = new HashMap<>();
        List<RegionCityEntity> list= regionCityService.list();
        RegionCityEntity region = regionCityService.getById(id);
        System.out.println(region.getDescribes());
        result.put("data",list);
        return ResultUtil.resultSuccess(result);
    }

}
