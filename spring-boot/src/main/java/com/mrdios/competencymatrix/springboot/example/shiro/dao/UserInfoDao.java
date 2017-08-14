package com.mrdios.competencymatrix.springboot.example.shiro.dao;

import com.mrdios.competencymatrix.springboot.example.shiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author MrDios
 * @date 2017-08-09
 */
public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    UserInfo findUserInfoByUsername(String username);
}
