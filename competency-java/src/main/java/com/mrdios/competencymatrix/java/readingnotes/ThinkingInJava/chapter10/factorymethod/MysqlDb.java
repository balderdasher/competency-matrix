package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.factorymethod;

/**
 * mysql 数据库服务
 *
 * @author huxiong
 * @date 2016/06/27 20:20
 */
public class MysqlDb implements DbService {
    private MysqlDb() {
    }

    @Override
    public void connect() {
        System.out.println("Mysql connect...");
    }

    @Override
    public void query() {
        System.out.println("Mysql query...");
    }

    public static DbServiceFactory factory = new DbServiceFactory() {
        @Override
        public DbService getDbService() {
            return new MysqlDb();
        }
    };
}
