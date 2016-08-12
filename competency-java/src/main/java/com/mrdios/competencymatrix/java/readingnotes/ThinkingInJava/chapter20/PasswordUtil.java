package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20;

import java.util.List;

/**
 * "@UseCase"注解的使用
 *
 * @author mrdios
 * @date 2016-07-26 14:57
 */
public class PasswordUtil {
    @UseCase(id = 47, description = "密码必须包含至少一位数字")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "检查是不是新的密码")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
