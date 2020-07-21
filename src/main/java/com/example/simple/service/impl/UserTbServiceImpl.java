package com.example.simple.service.impl;

import com.example.simple.dao.UserTbMapper;
import com.example.simple.entity.UserTb;
import com.example.simple.service.UserTbService;
import com.example.simple.core.universal.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}