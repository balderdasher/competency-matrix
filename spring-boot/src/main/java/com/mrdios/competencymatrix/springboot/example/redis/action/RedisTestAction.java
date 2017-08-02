package com.mrdios.competencymatrix.springboot.example.redis.action;

import com.mrdios.competencymatrix.springboot.example.jpa.dao.UserDao;
import com.mrdios.competencymatrix.springboot.example.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试查找数据库时使用redis缓存
 *
 * @author MrDios
 * @date 2017-08-02
 */
@RestController
@RequestMapping("/redis")
public class RedisTestAction {
    @Autowired
    private UserDao userDao;

    /**
     * 使用数据库时用redis缓存，user-key就是缓存到redis中的key
     *
     * @return
     */
    @RequestMapping("/getUser")
    @Cacheable("user-key")
    public User getUser() {
        User user = userDao.findByUserName("bb2");
        System.out.println("若下面没有出现‘无缓存的时候调用’字样且能打印出数据表示测试成功");
        return user;
    }
}
