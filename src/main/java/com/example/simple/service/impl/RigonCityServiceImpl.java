package com.example.simple.service.impl;

import com.example.simple.dao.RigonCityMapper;
import com.example.simple.entity.RigonCity;
import com.example.simple.service.RigonCityService;
import com.example.simple.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: RigonCityService接口实现类
* @author 沉香大神
* @date 2020/07/21 23:11
*/
@Service
public class RigonCityServiceImpl extends AbstractService<RigonCity> implements RigonCityService {

    @Resource
    private RigonCityMapper rigonCityMapper;

}