package com.mrdios.competencymatrix.spring.aop.example.advance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：用于标记需要日志记录的方法
 *
 * @author mrdios
 * @date 2017-08-26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRequired {
    boolean value() default true;
}
