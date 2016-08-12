package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter20.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器
 *
 * @author mrdios
 * @date 2016-07-26 17:01
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
        List<Class<?>> beanClasses = new ArrayList<>();
        Collections.addAll(beanClasses, Member.class);
        process(beanClasses);
    }

    public static void process(List<Class<?>> beanClasses) throws Exception {
        for (Class c1 : beanClasses) {
            Class<?> c = Class.forName(c1.getName());
            DBTable dbTable = c.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + c.getName());
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = c.getSimpleName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : c.getDeclaredFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                if (field.isAnnotationPresent(SQLInteger.class)) {
                    SQLInteger sInt = field.getAnnotation(SQLInteger.class);
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (field.isAnnotationPresent(SQLString.class)) {
                    SQLString sString = field.getAnnotation(SQLString.class);
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n   ").append(columnDef).append(",");
                }
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + c.getName() + " is : \n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
