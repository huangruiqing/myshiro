package com.example.demo.dao;

import com.example.demo.model.SysRolePermission;

import java.util.List;

/**
 * @ClassName SysRolePermissionMapper
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 15:03
 */
public interface SysRolePermissionMapper {
    List<SysRolePermission> getRolePermissionsByRoleCodes(List<String> roleCodes);
}
