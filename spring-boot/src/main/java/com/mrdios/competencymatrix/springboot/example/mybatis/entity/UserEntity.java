package com.mrdios.competencymatrix.springboot.example.mybatis.entity;

import com.mrdios.competencymatrix.springboot.example.mybatis.enums.Sex;

import java.io.Serializable;

/**
 * @author MrDios
 * @date 2017-08-04
 */
public class UserEntity implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private Sex sex;
    private String nickName;

    public UserEntity() {
        super();
    }

    public UserEntity(String userName, String password, Sex sex, String nickName) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
