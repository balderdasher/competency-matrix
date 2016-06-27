package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * mysql 数据库服务
 *
 * @author huxiong
 * @date 2016/06/27 20:20
 */
public class MysqlDb implements DbService {

    @Override
    public void connect() {
        System.out.println("Mysql connect...");
    }

    @Override
    public void query() {
        System.out.println("Mysql query...");
    }
}
