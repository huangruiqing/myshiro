package com.example.demo.service.impl;

import com.example.demo.dao.SysPermissionMapper;
import com.example.demo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:42
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        return sysPermissionMapper.queryPermissionByUserId(userId);
    }
}
