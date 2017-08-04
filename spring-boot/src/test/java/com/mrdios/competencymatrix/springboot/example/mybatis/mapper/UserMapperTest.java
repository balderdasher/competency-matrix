package com.mrdios.competencymatrix.springboot.example.mybatis.mapper;

import com.mrdios.competencymatrix.springboot.example.MainApplication;
import com.mrdios.competencymatrix.springboot.example.mybatis.entity.UserEntity;
import com.mrdios.competencymatrix.springboot.example.mybatis.enums.Sex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 注解方式使用mybatis测试
 *
 * @author MrDios
 * @date 2017-08-04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        userMapper.insert(new UserEntity("aa", "a123456", Sex.MALE, "aa"));
        userMapper.insert(new UserEntity("bb", "b123456", Sex.FEMALE, "bb"));
        userMapper.insert(new UserEntity("cc", "c123456", Sex.MALE, "cc"));
        assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void get() throws Exception {
        System.out.println(userMapper.get(34L));
    }

    @Test
    public void getAll() throws Exception {
        System.out.println(userMapper.getAll());
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}