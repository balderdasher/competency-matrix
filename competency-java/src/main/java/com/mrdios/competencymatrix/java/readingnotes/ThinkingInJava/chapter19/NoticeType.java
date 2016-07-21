package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter19;

/**
 * @author huxiong
 * @date 2015/09/20 23:34
 */
public enum NoticeType {
    SUCCESS("成功","成功"),
    ERROR("错误","错误"),
    WARN("警告","警告"),
    INFO("提示","提示");

    private String name;
    private String desc;

    NoticeType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
