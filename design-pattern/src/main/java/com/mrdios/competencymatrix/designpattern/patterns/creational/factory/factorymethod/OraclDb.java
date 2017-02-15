package com.mrdios.competencymatrix.designpattern.patterns.creational.factory.factorymethod;

/**
 * @author huxiong
 * @date 2017-01-20 15:13
 */
public class OraclDb implements DbService {

    private OraclDb() {

    }

    @Override
    public void conncet() {
        System.out.println("Oracl connecting...");
    }

    @Override
    public void query() {
        System.out.println("Oracl querying...");
    }

    public static DbServiceFactory factory = new DbServiceFactory() {
        @Override
        public DbService getDbService() {
            return new OraclDb();
        }
    };
}
