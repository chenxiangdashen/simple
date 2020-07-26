package com.example.simple.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.simple.core.dao.SysRoleDao;
import com.example.simple.core.entity.SysRoleEntity;
import com.example.simple.core.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色业务实现
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}