package com.mrdios.competencymatrix.designpattern.patterns.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤男性人员的标准
 *
 * @author huxiong
 * @date 2017-01-24 14:58
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if ("MALE".equalsIgnoreCase(person.getGender())) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
