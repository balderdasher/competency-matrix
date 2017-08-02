package com.mrdios.competencymatrix.springboot.example.redis;

import com.mrdios.competencymatrix.springboot.example.jpa.entity.User;
import com.mrdios.competencymatrix.springboot.example.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * spring-boot-redis测试
 *
 * @author MrDios
 * @date 2017-08-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa1", "123", "aa@qq.com", "aa", "2017-08-02 11:50:20");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.mrdios", user);
        operations.set("com.missdios", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exist = redisTemplate.hasKey("com.mrdios");
        if (exist) {
            System.out.println("has key missdios in redis");
        } else {
            System.out.println("has no key missdios in redis");
        }
    }

    @Test
    public void testGet() throws Exception {
        User user = (User) redisTemplate.opsForValue().get("com.mrdios");
        System.out.println(user);
    }
}