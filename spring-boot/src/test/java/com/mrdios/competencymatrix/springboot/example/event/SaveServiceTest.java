package com.mrdios.competencymatrix.springboot.example.event;
import com.mrdios.competencymatrix.springboot.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huxiong
 * @date 2018-05-02 11:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SaveServiceTest {

    @Resource
    private SaveService saveService;

    @Test
    public void save() {
        saveService.save();
    }
}