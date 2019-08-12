package com.example.demo.model;

import com.example.demo.model.base.BaseJsonModel;

/**
 * @ClassName SysPermission
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 16:23
 */
public class SysPermission extends BaseJsonModel {
    private static final long serialVersionUID = -5465371493823861235L;
    private Long id;
    private String permissionName;
    private String permissionCode;
    private String permission;
    private String url;
    private String type;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
