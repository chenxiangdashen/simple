package com.example.simple.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.simple.core.entity.RegionCityEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description 系统用户DAO
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Mapper
public interface RegionCityDao extends BaseMapper<RegionCityEntity> {

//    /**
//     * 通过用户ID查询角色集合
//     * @Author Sans
//     * @CreateTime 2019/9/18 18:01
//     * @Param  userId 用户ID
//     * @Return List<SysRoleEntity> 角色名集合
//     */
//    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
//    /**
//     * 通过用户ID查询权限集合
//     * @Author Sans
//     * @CreateTime 2019/9/18 18:01
//     * @Param  userId 用户ID
//     * @Return List<SysMenuEntity> 角色名集合
//     */
//    List<SysMenuEntity> selectSysMenuByUserId(Long userId);
	
}
