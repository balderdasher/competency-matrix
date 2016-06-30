package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.factorymethod;

/**
 * 数据库服务工厂接口
 * @author huxiong
 * @date 2016/06/27 20:18
 */
interface DbServiceFactory {
    DbService getDbService();
}
