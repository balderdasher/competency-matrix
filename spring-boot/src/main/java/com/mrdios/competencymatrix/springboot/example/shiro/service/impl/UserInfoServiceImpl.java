package com.mrdios.competencymatrix.springboot.example.shiro.service.impl;

import com.mrdios.competencymatrix.springboot.example.shiro.UserInfoService;
import com.mrdios.competencymatrix.springboot.example.shiro.dao.UserInfoDao;
import com.mrdios.competencymatrix.springboot.example.shiro.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MrDios
 * @date 2017-08-11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findUserInfoByUsername(username);
    }
}
