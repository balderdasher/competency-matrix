package com.mrdios.competencymatrix.springboot.example.web.jpa.dao;

import com.mrdios.competencymatrix.springboot.example.web.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MrDios
 * @date 2017-08-01
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String Email);
}
