package com.example.simple.controller;

import com.example.simple.core.ret.RetResult;
import com.example.simple.core.ret.RetResponse;
import com.example.simple.service.TokenService;
import com.example.simple.utils.ApplicationUtils;
import com.example.simple.entity.UserTb;
import com.example.simple.service.UserTbService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserTbController类
* @author 沉香大神
* @date 2020/07/22 00:52
*/
@RestController
@RequestMapping("/userTb")
public class UserTbController {

    @Resource
    private UserTbService userTbService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(UserTb userTb) throws Exception{
		userTb.setId(ApplicationUtils.getUUID());
    	Integer state = userTbService.insert(userTb);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userTbService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(UserTb userTb) throws Exception {
        Integer state = userTbService.update(userTb);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<UserTb> selectById(@RequestParam String id) throws Exception {
        UserTb userTb = userTbService.selectById(id);
        return RetResponse.makeOKRsp(userTb);
    }

    /**
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn RetResult<PageInfo<UserTb>>
	*/
    @PostMapping("/list")
    public RetResult<PageInfo<UserTb>> list(@RequestParam(defaultValue = "0") Integer page,
					@RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserTb> list = userTbService.selectAll();
        PageInfo<UserTb> pageInfo = new PageInfo<UserTb>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}