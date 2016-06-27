package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * oracle 数据库服务工厂
 * @author huxiong
 * @date 2016/06/27 20:30
 */
public class OracleDbFactory implements DbServiceFactory {
    @Override
    public DbService getDbService() {
        return new OracleDb();
    }
}
