package com.example.simple.controller;

import com.example.simple.core.ret.RetResponse;
import com.example.simple.core.ret.RetResult;
import com.example.simple.entity.UserTb;
import com.example.simple.service.UserTbService;
import com.example.simple.service.impl.UserTbServiceImpl;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

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
    private UserTbServiceImpl sysUserService;

    /**
     * 用户登录接口
     *
     * @param sysUser 用户登录的用户名和密码
     * @return 用户Token和角色
     * @throws AuthenticationException 身份验证错误抛出异常
     */
    @PostMapping(value = "/login")
    public RetResult login(@RequestBody final UserTb sysUser) throws AuthenticationException {
        return RetResponse.makeOKRsp(sysUserService.login(sysUser));
    }

//    /**
//     * 用户注册接口
//     *
//     * @param sysUser 用户注册信息
//     * @return 用户注册结果
//     */
//    @PostMapping(value = "/register")
//    public MyResponse register(@RequestBody @Valid final SysUser sysUser) {
//        return sysUserService.save(sysUser);
//    }

    /**
     * 这是登录用户才可以看到的内容
     */
    @GetMapping(value = "/message")
    public String message() {
        return "这个消息只有登录用户才可以看到";
    }

}