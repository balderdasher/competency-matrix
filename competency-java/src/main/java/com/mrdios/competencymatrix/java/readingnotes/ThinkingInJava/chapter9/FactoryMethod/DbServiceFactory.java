package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter9.FactoryMethod;

/**
 * 数据库服务工厂接口
 * @author huxiong
 * @date 2016/06/27 20:18
 */
interface DbServiceFactory {
    DbService getDbService();
}
