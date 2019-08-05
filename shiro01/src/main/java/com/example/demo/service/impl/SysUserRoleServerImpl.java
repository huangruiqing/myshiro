package com.example.demo.service.impl;

import com.example.demo.dao.SysUserRoleMapper;
import com.example.demo.model.SysUserRole;
import com.example.demo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserRoleServerImpl
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:23
 */
@Service
public class SysUserRoleServerImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<SysUserRole> userRolesByUserId(Long userId) {
        return sysUserRoleMapper.userRolesByUserId(userId);
    }
}
