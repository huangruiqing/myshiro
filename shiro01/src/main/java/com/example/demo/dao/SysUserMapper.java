package com.example.demo.dao;

import com.example.demo.model.SysUser;
import org.springframework.stereotype.Component;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @ClassName SysUserMapper
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:49
 */

public interface SysUserMapper {
     SysUser findByUserName(@PathParam("userName") String userName);

     SysUser queryById(@PathParam("id")Long id);

     List<SysUser> getSysUsers();
}
