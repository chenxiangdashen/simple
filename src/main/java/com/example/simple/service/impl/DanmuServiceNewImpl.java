package com.example.simple.service.impl;

import com.example.simple.core.universal.AbstractService;
import com.example.simple.dao.DanmuMapper;
import com.example.simple.entity.Danmu;
import com.example.simple.service.DanmuServiceNew;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张瑶
 * @Description:
 * @time 2018/4/18 11:56
 */
@Service
public class DanmuServiceNewImpl extends AbstractService<Danmu> implements DanmuServiceNew {

    @Resource
    private DanmuMapper danmuMapper;


    @Override
    public List<Danmu> selectAlla(int pageNum, int pageSize) {
        return danmuMapper.selectAll(pageNum,pageSize);
    }

}
