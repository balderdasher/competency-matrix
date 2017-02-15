package com.mrdios.competencymatrix.designpattern.patterns.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 单身狗统计
 *
 * @author huxiong
 * @date 2017-01-24 15:06
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("SINGLE".equalsIgnoreCase(person.getMaritalStatus())) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
