package com.example.demo.model;

/**
 * @ClassName SysUserRoleMapper
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 16:39
 */
public class SysUserRole {
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
