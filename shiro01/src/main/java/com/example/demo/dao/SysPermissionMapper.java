package com.example.demo.dao;

import com.example.demo.model.SysPermission;

import java.util.List;

/**
 * @ClassName SysPermissionMapper
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 19:22
 */
public interface SysPermissionMapper {

    List<SysPermission> queryPermissionByCode(Long userId);

    List<SysPermission> getSysPermissionByCode(List<String> permissionCodes);
}
