package com.mrdios.competencymatrix.springboot.example.shiro;

import com.mrdios.competencymatrix.springboot.example.shiro.entity.UserInfo;

/**
 * @author MrDios
 * @date 2017-08-11
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
