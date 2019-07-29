package com.example.demo.service;

import com.example.demo.model.SysUser;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:36
 */
public interface SysUserService {
    SysUser findByUserName(String userName);

    SysUser selectById(Long id);

    List<SysUser> getUsers();
}
