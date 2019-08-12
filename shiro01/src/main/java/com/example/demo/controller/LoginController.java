package com.example.demo.controller;

import com.example.demo.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName LoginController
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 16:08
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * get请求，登录页面跳转
     * @return
     */
    @GetMapping("/login")
    public String login() {
        //如果已经认证通过，直接跳转到首页
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "loginPage";
    }

    /**
     * post表单提交，登录
     * @param
     * @param password
     * @param model
     * @return
     */
    @PostMapping("/login")
    public Object login(String userName, String password, Model model) {
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
        //    token.setRememberMe(true);
            user.login(token);
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            model.addAttribute("message", "账号不存在！");
            logger.error("登录异常账号不存在！msg:{}",e.getMessage(),e);
        } catch (DisabledAccountException e) {
            model.addAttribute("message", "账号未启用！");
            logger.error("登录异常账号未启用！msg:{}",e.getMessage(),e);
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "密码错误！");
            logger.error("登录异常密码错误！msg:{}",e.getMessage(),e);
        } catch (Throwable e) {
            model.addAttribute("message", "未知错误！");
            logger.error("登录异常未知错误！msg:{}",e.getMessage(),e);
        }
        return "loginPage";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            SysUser sysUser = (SysUser) subject.getPrincipal();
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            if (logger.isDebugEnabled()) {
                logger.debug("用户" + sysUser.getUserName() + "退出登录");
            }
        }
        model.addAttribute("message","had logout");
        return "loginPage";
    }

}
