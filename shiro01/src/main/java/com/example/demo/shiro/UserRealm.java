package com.example.demo.shiro;

import com.example.demo.model.SysPermission;
import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import com.example.demo.service.SysPermissionService;
import com.example.demo.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:30
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       /* SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        LOGGER.info("doGetAuthorizationInfo 授权");
        return info;*/

        //获取前端输入的用户信息，封装为User对象
        SysUser userweb = (SysUser) principals.getPrimaryPrincipal();
        //获取前端输入的用户名
        String userName = userweb.getUserName();
        //根据前端输入的用户名查询数据库中对应的记录
        SysUser user = sysUserService.findByUserName(userName);
        //如果数据库中有该用户名对应的记录，就进行授权操作
        if (user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //因为addRoles和addStringPermissions方法需要的参数类型是Collection
            //所以先创建两个collection集合
            Collection<String> rolesCollection = new HashSet<String>();
            Collection<String> perStringCollection = new HashSet<String>();
            //获取user的Role的set集合
            Set<SysRole> roles = user.getRoles();
            //遍历集合
            for (SysRole role : roles){
                //将每一个role的name装进collection集合
                rolesCollection.add(role.getRoleCode());
                //获取每一个Role的permission的set集合
                Set<SysPermission> permissionSet =  role.getPermissions();
                //遍历集合
                for (SysPermission permission : permissionSet){
                    //将每一个permission的name装进collection集合
                    perStringCollection.add(permission.getPermissionCode());
                }
                //为用户授权
                info.addStringPermissions(perStringCollection);
            }
            //为用户授予角色
            info.addRoles(rolesCollection);
            return info;
        }else{
            return null;
        }
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserService.findByUserName(token.getUsername());
        if (sysUser == null) {
            return null;
        }
        LOGGER.info("doGetAuthenticationInfo 认证");
        ByteSource salt = ByteSource.Util.bytes(sysUser.getPasswdSalt());
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(),salt , getName());
    }


}
