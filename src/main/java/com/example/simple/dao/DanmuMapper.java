package com.example.simple.dao;

import com.example.simple.core.universal.Mapper;
import com.example.simple.entity.Danmu;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张瑶
 * @Description:
 * @time 2018/4/18 11:54
 */
public interface DanmuMapper extends Mapper<Danmu> {

    List<Danmu> selectAll(@Param("pageNumKey") int pageNum,
                          @Param("pageSizeKey") int pageSize);
}
