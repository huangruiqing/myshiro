package com.example.demo.service;

import com.example.demo.model.SysRole;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleService
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:29
 */
public interface SysRoleService {

    List<SysRole>  sysRoles(List<String> roleCodes);

}
