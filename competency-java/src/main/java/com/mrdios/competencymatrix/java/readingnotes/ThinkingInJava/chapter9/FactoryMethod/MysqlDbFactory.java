package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * mysql 数据库服务工厂
 * @author huxiong
 * @date 2016/06/27 20:28
 */
public class MysqlDbFactory implements DbServiceFactory {
    @Override
    public DbService getDbService() {
        return new MysqlDb();
    }
}
