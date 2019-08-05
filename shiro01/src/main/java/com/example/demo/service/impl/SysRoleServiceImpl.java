package com.example.demo.service.impl;

import com.example.demo.dao.SysRoleMapper;
import com.example.demo.model.SysRole;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:30
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<SysRole> sysRoles(List<String> roleCodes) {
        return sysRoleMapper.sysRoleByRoleCodes(roleCodes);
    }
}
