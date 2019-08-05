package com.example.demo.dao;

import com.example.demo.model.SysRole;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleMapper
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:31
 */
public interface SysRoleMapper {

    List<SysRole> sysRoleByRoleCodes(List<String> roleCodes);

}
