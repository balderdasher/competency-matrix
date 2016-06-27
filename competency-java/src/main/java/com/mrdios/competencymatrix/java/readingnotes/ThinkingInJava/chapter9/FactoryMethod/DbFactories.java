package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * 工厂方法模式
 *
 * @author huxiong
 * @date 2016/06/27 20:25
 */
public class DbFactories {
    public static void serviceConsumer(DbServiceFactory fact) {
        DbService dbService = fact.getDbService();
        dbService.connect();
        dbService.query();
    }

    public static void main(String[] args) {
        serviceConsumer(new MysqlDbFactory());
        serviceConsumer(new OracleDbFactory());
    }
}
