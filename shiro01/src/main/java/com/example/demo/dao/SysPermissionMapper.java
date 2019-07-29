package com.example.demo.dao;

import java.util.List;

/**
 * @ClassName SysPermissionMapper
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 19:22
 */
public interface SysPermissionMapper {
    List<String> queryPermissionByUserId(Long userId);
}
