package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.factorymethod;

/**
 * @author huxiong
 * @date 2017-01-20 15:23
 */
public class App {
    public static void dbServiceConsumer(DbServiceFactory factory) {
        DbService service = factory.getDbService();
        service.conncet();
        service.query();
    }

    public static void main(String[] args) {
        dbServiceConsumer(MysqlDb.factory);
        dbServiceConsumer(OraclDb.factory);
    }
}
