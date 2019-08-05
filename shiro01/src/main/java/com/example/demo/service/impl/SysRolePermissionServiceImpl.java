package com.example.demo.service.impl;

import com.example.demo.dao.SysRolePermissionMapper;
import com.example.demo.model.SysRolePermission;
import com.example.demo.service.SysRolePermissionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysRolePermissionServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 14:29
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    private Logger logger = LoggerFactory.getLogger(SysRolePermissionServiceImpl.class);

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRolePermission> getSysRolePermissionByRoleCode(List<String> roleCodes) {

        return sysRolePermissionMapper.getRolePermissionsByRoleCodes(roleCodes);
    }
}
