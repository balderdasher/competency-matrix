package com.mrdios.competencymatrix.designpattern.patterns.behavioral.iterator;

/**
 * @author huxiong
 * @date 2017-02-17 15:58
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
