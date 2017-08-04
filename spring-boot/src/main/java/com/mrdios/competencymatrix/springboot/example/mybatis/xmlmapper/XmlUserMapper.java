package com.mrdios.competencymatrix.springboot.example.mybatis.xmlmapper;

import com.mrdios.competencymatrix.springboot.example.mybatis.entity.UserEntity;

import java.util.List;

/**
 * mybatis mapper
 * 极简xml方式使用mybatis
 *
 * @author MrDios
 * @date 2017-08-04
 */
public interface XmlUserMapper {
    void insert(UserEntity user);

    UserEntity get(Long id);

    List<UserEntity> getAll();

    void update(UserEntity user);

    void delete(Long id);
}
