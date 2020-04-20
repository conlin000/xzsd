package com.xzsd.app.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>密码工具类</p>
 * <p>创建日期：2018-01-11</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PasswordUtils {

    /**
     * 生成加密后的密码
     *
     * @param rawPassword 原密码
     * @return 加密后的密码
     */
    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }


    /**
     * 判断输入的密码是否与原密码匹配
     *
     * & 参数：rawPassword   输入的原密码
     * & 参数：encodedPassword  数据库里的密码
     */
    public static boolean isOk (String rawPassword, String encodedPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
