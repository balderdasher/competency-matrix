package com.mrdios.competencymatrix.designpattern.patterns.structural.filter;

import java.util.List;

/**
 * 为标准（Criteria）创建一个接口
 * 此接口为过滤某种数据而定义的接口
 *
 * @author huxiong
 * @date 2017-01-24 14:57
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
