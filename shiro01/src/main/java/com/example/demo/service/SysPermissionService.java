package com.example.demo.service;

import java.util.List;

/**
 * @ClassName SysPermissionService
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:36
 */
public interface SysPermissionService {

   List<String> selectPermissionByUserId(Long userId);
}
