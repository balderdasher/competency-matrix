package com.mrdios.competencymatrix.springboot.example.redis.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 分布式Session共享
 *
 * @author MrDios
 * @date 2017-08-02
 */
@RestController
@RequestMapping("/session")
public class DistributSessionAction {

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
