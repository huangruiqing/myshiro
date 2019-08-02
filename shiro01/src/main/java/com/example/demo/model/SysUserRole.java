package com.example.demo.model;

/**
 * @ClassName SysUserRole
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 16:39
 */
public class SysUserRole {
    private Long id;
    private Long user_id;
    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
