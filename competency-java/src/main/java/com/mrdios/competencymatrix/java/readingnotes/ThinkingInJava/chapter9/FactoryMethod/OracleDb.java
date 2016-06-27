package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * oracle 数据库服务
 *
 * @author huxiong
 * @date 2016/06/27 20:22
 */
public class OracleDb implements DbService {
    @Override
    public void connect() {
        System.out.println("Oracle connect...");
    }

    @Override
    public void query() {
        System.out.println("Oracle query...");
    }
}
