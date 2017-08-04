package com.mrdios.competencymatrix.springboot.example.mybatis.mapper;

import com.mrdios.competencymatrix.springboot.example.mybatis.entity.UserEntity;
import com.mrdios.competencymatrix.springboot.example.mybatis.enums.Sex;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mybatis mapper
 * 注解方式使用mybatis
 *
 * @author MrDios
 * @date 2017-08-04
 */
public interface UserMapper {
    @Insert("INSERT INTO users(userName,password,user_sex) VALUES(#{userName},#{password},#{sex})")
    void insert(UserEntity user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "sex", column = "user_sex", javaType = Sex.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity get(Long id);

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "sex", column = "user_sex", javaType = Sex.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id=#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(Long id);
}
