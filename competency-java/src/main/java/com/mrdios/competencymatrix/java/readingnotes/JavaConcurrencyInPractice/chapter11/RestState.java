package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter11;

import javax.annotation.Generated;
import java.util.Set;

/**
 * 锁分解
 * @author huxiong
 * @date 2016/06/22 12:59
 */
public class RestState {
    @Generated("this")
    public final Set<String> users;//食客
    @Generated("this")
    public final Set<String> reserves;//预定

    public RestState(Set<String> users, Set<String> reserves) {
        this.users = users;
        this.reserves = reserves;
    }

    public void addUser(String user){
        synchronized (users){
            users.add(user);
        }
    }

    public void addReserves(String reserv){
        synchronized (reserves){
            reserves.add(reserv);
        }
    }
}
