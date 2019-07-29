package com.example.demo.controller;

import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 19:14
 */
@RestController
public class UserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/users")
    public List<SysUser> lists() {
        List<SysUser> sysUsers =  userService.getUsers();
        return sysUsers;
    }

    @GetMapping("/user/{id}")
    public SysUser selectUserById(@PathVariable("id") Long id){
        return userService.selectById(id);
    }

}
