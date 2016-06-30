package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.factorymethod;

/**
 * oracle 数据库服务
 *
 * @author huxiong
 * @date 2016/06/27 20:22
 */
public class OracleDb implements DbService {
    private OracleDb(){}
    @Override
    public void connect() {
        System.out.println("Oracle connect...");
    }
    @Override
    public void query() {
        System.out.println("Oracle query...");
    }
    public static DbServiceFactory factory = new DbServiceFactory() {
        @Override
        public DbService getDbService() {
            return new OracleDb();
        }
    };
}
