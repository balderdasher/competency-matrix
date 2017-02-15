package com.mrdios.competencymatrix.designpattern.patterns.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤女性人员的标准
 *
 * @author huxiong
 * @date 2017-01-24 15:01
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person peron : persons) {
            if ("FEMALE".equalsIgnoreCase(peron.getGender())) {
                femalePersons.add(peron);
            }
        }
        return femalePersons;
    }
}
