package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * sql类型
 *
 * @author mrdios
 * @date 2016-07-26 16:26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;
}
