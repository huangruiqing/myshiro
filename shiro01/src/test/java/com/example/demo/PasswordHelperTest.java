package com.example.demo;

import com.example.demo.model.SysUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * @ClassName PasswordHelperTest
 * @Description
 * @Author huangrq
 * @Date 2019/8/2 15:15
 */
public class PasswordHelperTest {


    private String algorithmName = "md5";
    private int hashIterations = 1;

    public void encryptPassword(SysUser user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUserName()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        System.out.println(newPassword);
        user.setPassword(newPassword);

    }
    public static void main(String[] args) {
        /*PasswordHelperTest passwordHelper = new PasswordHelperTest();
        SysUser user = new SysUser();
        user.setUserName("admin");
        user.setPassword("admin");
        passwordHelper.encryptPassword(user);
        System.out.println(user);*/
        testEncryption();
    }


    @Test
    public static void testEncryption() {
        String hashAlgorithmName = "md5";//加密方式
        Object passwd = "1";//密码原值
        String saltStr = "1";//盐值
        ByteSource salt = ByteSource.Util.bytes(saltStr);
        int hashIterations = 2;//加密1024次
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, passwd, salt, hashIterations);
        System.out.println(simpleHash);
        System.out.println(simpleHash.toHex());


    }

}
