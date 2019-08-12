package com.example.demo.model;

import com.example.demo.model.base.BaseJsonModel;

/**
 * @ClassName SysRolePermission
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 14:26
 */
public class SysRolePermission extends BaseJsonModel {

    private static final long serialVersionUID = -4904829218625930639L;
    private Long id;
    private String roleCode;
    private String permissionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
}
