package com.mrdios.competencymatrix.springboot.example.web.jpa.dao;

import com.mrdios.competencymatrix.springboot.example.web.MainApplication;
import com.mrdios.competencymatrix.springboot.example.web.jpa.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.config.SpringDataWebConfigurationMixin;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * jpa测试
 *
 * @author MrDios
 * @date 2017-08-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser() throws Exception {
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formateDate = df.format(date);

        userDao.save(new User("aa1", "123", "aa@qq.com", "aa", formateDate));
        userDao.save(new User("bb2", "123", "bb@qq.com", "bb", formateDate));
        userDao.save(new User("cc3", "123", "cc@qq.com", "cc", formateDate));

        Assert.assertEquals(9, userDao.findAll().size());
    }

    @Test
    public void findByUserName() throws Exception {
        User user = userDao.findByUserName("aa1");
        System.out.println(user);
    }

    @Test
    public void findByUserNameOrEmail() throws Exception {
        Assert.assertEquals("bb", userDao.findByUserNameOrEmail("bb", "cc@qq.com").getNickName());
    }

    @Test
    public void delete() {
        userDao.delete(userDao.findByUserName("aa1"));
    }

}