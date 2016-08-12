package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表字段约束注解
 *
 * @author mrdios
 * @date 2016-07-26 16:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    /* 是否主键 */
    boolean primaryKey() default false;

    /* 是否允许为空 */
    boolean allowNull() default true;

    /* 是否唯一 */
    boolean unique() default false;
}
