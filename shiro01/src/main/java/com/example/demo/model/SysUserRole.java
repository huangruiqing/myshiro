package com.example.demo.model;

import com.example.demo.model.base.BaseJsonModel;

/**
 * @ClassName SysUserRoleMapper
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 16:39
 */
public class SysUserRole extends BaseJsonModel {
    private static final long serialVersionUID = -7403413447539936491L;
    private Long id;
    private Long userId;
    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
