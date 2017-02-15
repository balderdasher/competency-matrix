package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.factorymethod;

/**
 * 匿名内部类优化的工厂方法模式，不用针对每个产品创建相应的工厂
 *
 * @author huxiong
 * @date 2017-01-20 15:13
 */
public class MysqlDb implements DbService {

    private MysqlDb() {
    }

    @Override
    public void conncet() {
        System.out.println("Mysql connecting...");
    }

    @Override
    public void query() {
        System.out.println("Mysql querying...");
    }

    public static DbServiceFactory factory = new DbServiceFactory() {
        @Override
        public DbService getDbService() {
            return new MysqlDb();
        }
    };
}
