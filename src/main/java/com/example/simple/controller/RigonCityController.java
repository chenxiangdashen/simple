package com.example.simple.controller;

import com.example.simple.core.ret.RetResult;
import com.example.simple.core.ret.RetResponse;
import com.example.simple.utils.ApplicationUtils;
import com.example.simple.entity.RigonCity;
import com.example.simple.service.RigonCityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: RigonCityController类
* @author 沉香大神
* @date 2020/07/21 23:11
*/
@RestController
@RequestMapping("/rigonCity")
public class RigonCityController {

    @Resource
    private RigonCityService rigonCityService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(RigonCity rigonCity) throws Exception{
		rigonCity.setId(ApplicationUtils.getUUID());
    	Integer state = rigonCityService.insert(rigonCity);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = rigonCityService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(RigonCity rigonCity) throws Exception {
        Integer state = rigonCityService.update(rigonCity);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<RigonCity> selectById(@RequestParam String id) throws Exception {
        RigonCity rigonCity = rigonCityService.selectById(id);
        return RetResponse.makeOKRsp(rigonCity);
    }

    /**
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn RetResult<PageInfo<RigonCity>>
	*/
    @PostMapping("/list")
    public RetResult<PageInfo<RigonCity>> list(@RequestParam(defaultValue = "0") Integer page,
					@RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<RigonCity> list = rigonCityService.selectAll();
        PageInfo<RigonCity> pageInfo = new PageInfo<RigonCity>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}