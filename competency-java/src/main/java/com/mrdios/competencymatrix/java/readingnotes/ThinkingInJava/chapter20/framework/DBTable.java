package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表的注解，用于实体bean类上，说明该实体生成的数据库表信息
 *
 * @author mrdios
 * @date 2016-07-26 16:17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
