package com.example.demo.model;

/**
 * @ClassName SysRole
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 16:23
 */
public class SysRole {
    private Long id;
    private String roleCode;
    private String roleNmae;
    private String type;//类型 菜单 / 按钮
    private String state;// 使用状态

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

    public String getRoleNmae() {
        return roleNmae;
    }

    public void setRoleNmae(String roleNmae) {
        this.roleNmae = roleNmae;
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
