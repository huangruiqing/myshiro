package com.example.demo.controller;

import com.example.demo.model.FastjsonTest;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName TestController
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 17:30
 */
@RestController
public class TestController {
    @GetMapping("/fastjson")
    public FastjsonTest getFastJson() {
        FastjsonTest fastjsonTest = new FastjsonTest();
        fastjsonTest.setId(1);
        fastjsonTest.setString("fastjson test");
        fastjsonTest.setIgnore("ignore field");
        fastjsonTest.setDate(new Date());
        return fastjsonTest;
    }

    /**
     * 没有加shiro权限注解
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }

    /**
     * 添加了shiro权限注解，需要用户有"systemUserAdd"权限
     * @return
     */
    @RequestMapping("/test2")
    //@RequiresPermissions(value={"user:add","user:remove"}, logical = Logical.OR)//用于其一
    @RequiresPermissions(value={"user:add"}, logical = Logical.AND)//同时有
    public String test2(){
        return "test2";
    }

}
