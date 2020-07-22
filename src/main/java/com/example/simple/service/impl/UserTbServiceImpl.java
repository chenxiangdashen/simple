package com.example.simple.service.impl;

import com.example.simple.dao.UserTbMapper;
import com.example.simple.entity.UserTb;
import com.example.simple.service.UserTbService;
import com.example.simple.core.universal.AbstractService;
import com.example.simple.utils.TokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: UserTbService接口实现类
* @author 沉香大神
* @date 2020/07/22 00:52
*/
@Service
public class UserTbServiceImpl extends AbstractService<UserTb> implements UserTbService {

    @Resource
    private UserTbMapper userMapper;

    public UserTb findByUsername(UserTb user){
        return userMapper.findByUsername(user.getUsername());
    }
    public UserTb findUserById(String userId) {
        return userMapper.findUserById(userId);
    }


    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private UserTbMapper sysUserMapper;
    /**
     * 用户登录
     *
     * @param sysUser 用户登录信息
     * @return 用户登录成功返回的Token
     */
    public String login(final UserTb sysUser) {
        try {
            // 验证用户名和密码是否对的
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(sysUser.getUsername(),
                            sysUser.getPassword()));
        } catch (BadCredentialsException e) {
            return "用户名或者密码不正确";
        }
        // 生成Token与查询用户权限
        UserTb sysUserData = sysUserMapper.findByUsername(sysUser.getUsername());
        return tokenUtils.createToken(sysUserData);
    }


}