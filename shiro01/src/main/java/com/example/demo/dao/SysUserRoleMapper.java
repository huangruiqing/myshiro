package com.example.demo.dao;

import com.example.demo.model.SysUserRole;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @ClassName SysUserRoleMapper
 * @Description
 * @Author huangrq
 * @Date 2019/8/5 10:16
 */
public interface SysUserRoleMapper {

        List<SysUserRole> userRolesByUserId(@PathVariable("userId") Long userId);
}
