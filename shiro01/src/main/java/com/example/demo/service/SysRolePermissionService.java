package com.example.demo.service;

import com.example.demo.model.SysRolePermission;

import java.util.List;

/**
 * @ClassName SysRolePermissionService
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 14:27
 */
public interface SysRolePermissionService {

    List<SysRolePermission> getSysRolePermissionByRoleCode(List<String> roleCodes);


}
