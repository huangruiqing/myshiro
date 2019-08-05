package com.example.demo.service;

import com.example.demo.model.SysPermission;
import com.example.demo.model.SysRole;
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
    //获取用户所有角色
    List<SysRole> getUserSysRolesByUserId(Long userId);

    List<SysPermission> gerUserPermissionByUserId(Long userId);

}
