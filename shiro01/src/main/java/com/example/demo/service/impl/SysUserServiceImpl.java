package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.SysPermissionMapper;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.model.SysPermission;
import com.example.demo.model.SysRole;
import com.example.demo.model.SysRolePermission;
import com.example.demo.model.SysUser;
import com.example.demo.model.SysUserRole;
import com.example.demo.service.SysRolePermissionService;
import com.example.demo.service.SysRoleService;
import com.example.demo.service.SysUserRoleService;
import com.example.demo.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:45
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }

    @Override
    public SysUser selectById(Long id) {
        return sysUserMapper.queryById(id);
    }

    @Override
    public List<SysUser> getUsers() {
        return sysUserMapper.getSysUsers();
    }

    @Override
    public List<SysRole> getUserSysRolesByUserId(Long userId) {
        List<SysUserRole> sysUserRoles =sysUserRoleService.userRolesByUserId(userId);
        logger.info("查询用户所有的角色关系 入参{},结果{}",userId,sysUserRoles);
        if(!sysUserRoles.isEmpty()) {
            List<String> roleCodes = new ArrayList<>();
            for (SysUserRole sysUserRole : sysUserRoles){
                roleCodes.add(sysUserRole.getRoleCode());
            }
            return sysRoleService.sysRoles(roleCodes);
        }
        return null;
    }

    @Override
    public List<SysPermission> gerUserPermissionByUserId(Long userId) {
        List<SysUserRole> sysUserRoles =sysUserRoleService.userRolesByUserId(userId);
        logger.info("step 1、查询用户所有的角色权限关系 入参:{},结果:{}",userId,JSONObject.toJSON(sysUserRoles));
        if(!sysUserRoles.isEmpty()) {
            List<String> roleCodes = new ArrayList<>();
            for (SysUserRole sysUserRole : sysUserRoles){
                roleCodes.add(sysUserRole.getRoleCode());
            }
            List<SysRolePermission> sysRolePermissions = sysRolePermissionService.getSysRolePermissionByRoleCode(roleCodes);
            if(!sysRolePermissions.isEmpty()){
                List<String> permissionCodes = new ArrayList<>();
                for (SysRolePermission sysRolePermission : sysRolePermissions) {
                    permissionCodes.add(sysRolePermission.getPermissionCode());
                }
                 List<SysPermission> sysPermissions = sysPermissionMapper.getSysPermissionByCode(permissionCodes);
                logger.info("step 2、查询用户所有的角色权限关系 入参:{},结果:{}",permissionCodes,sysPermissions);
                return  sysPermissions;
            }
        }
        return  null;
    }
}
