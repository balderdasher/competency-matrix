package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20.framework;

/**
 * JavaBean
 *
 * @author mrdios
 * @date 2016-07-26 16:33
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    private String firstName;
    @SQLString(50)
    private String lastName;
    @SQLInteger
    private Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    private String handle;
    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
