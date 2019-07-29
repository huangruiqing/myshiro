package com.example.demo.service.impl;

import com.example.demo.dao.SysUserMapper;
import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:45
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
       // return sysUserMapper.queryById(1L);
    }

    @Override
    public SysUser selectById(Long id) {
        return sysUserMapper.queryById(id);
    }

    @Override
    public List<SysUser> getUsers() {
        return sysUserMapper.getSysUsers();
    }
}
