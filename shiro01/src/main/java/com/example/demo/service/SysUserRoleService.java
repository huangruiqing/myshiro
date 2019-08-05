package com.example.demo.service;

import com.example.demo.model.SysUserRole;

import java.util.List;

/**
 * @ClassName SysUserRoleService
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:22
 */
public interface SysUserRoleService {

    List<SysUserRole> userRolesByUserId(Long userId);
}
