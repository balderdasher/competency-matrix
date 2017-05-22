package com.mrdios.competencymatrix.algorithm.strings.StringSorts;

/**
 * 字符串排序基础算法：索引计数法
 *
 * @author MrDios
 * @date 2017-05-22
 */
public class IndexCount {
    private int R = 5;      // 组号0到5-1之间
    private Student[] stu = new Student[20];

    public IndexCount() {
        stu[0] = new Student("Anderson", 2);
        stu[1] = new Student("Brown", 3);
        stu[2] = new Student("Davis", 3);
        stu[3] = new Student("Garcia", 4);
        stu[4] = new Student("Harris", 1);
        stu[5] = new Student("Jackson", 3);
        stu[6] = new Student("Johnson", 4);
        stu[7] = new Student("Jones", 3);
        stu[8] = new Student("Martin", 1);
        stu[9] = new Student("Martinez", 2);
        stu[10] = new Student("Miller", 2);
        stu[11] = new Student("Moore", 1);
        stu[12] = new Student("Robinson", 2);
        stu[13] = new Student("Smith", 4);
        stu[14] = new Student("Taylor", 3);
        stu[15] = new Student("Thomas", 4);
        stu[16] = new Student("Thompson", 4);
        stu[17] = new Student("White", 2);
        stu[18] = new Student("Williams", 3);
        stu[19] = new Student("Wilson", 4);
    }

    public Student[] sort() {
        int N = stu.length;

        Student[] aux = new Student[N];
        int[] count = new int[R + 1];

        // 计算出现频率
        for (int i = 0; i < N; i++) {
            count[stu[i].key() + 1]++;
        }
        // 将频率转化为索引
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        // 将元素分类
        for (int i = 0; i < N; i++) {
            aux[count[stu[i].key()]++] = stu[i];
        }
        // 回写
        for (int i = 0; i < N; i++) {
            stu[i] = aux[i];
        }
        return stu;
    }

    public static void main(String[] args) {
        Student[] stu = new IndexCount().sort();
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i]);
        }
    }
}

class Student {
    private String name;    // 姓名
    private int group;      // 组号

    public Student(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public int key() {
        return this.group;
    }

    @Override
    public String toString() {
        return this.name + "  " + this.group;
    }
}
