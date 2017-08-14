package com.mrdios.competencymatrix.springboot.example.shiro.action;

import com.mrdios.competencymatrix.springboot.example.shiro.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MrDios
 * @date 2017-08-11
 */
@Controller
public class ShiroTestAct {

    @Value("${info.app_name}")
    private String message;

    /**
     * 登录页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        // 已经登录跳转到首页
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            UserInfo principal = (UserInfo) subject.getPrincipal();
            if (principal != null) {
                return "redirect:/index";
            }
        }
        return "shiro/login";
    }

    /**
     * 登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) throws Exception {
        System.out.println("ShiroTestAct.login()");
        // 登录失败从request中获取shiro处理的异常信息
        // shiro异常类全类名：shiroLoginFailure
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (!StringUtils.isEmpty(exception)) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "UnknownAccountException --> 账号不存在";
                System.out.println(msg);
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "IncorrectCredentialsException --> 密码不对";
                System.out.println(msg);
            } else if ("kaptchaValidateFaild".equals(exception)) {
                msg = "kaptchaValidateFaild --> 验证码不对";
                System.out.println(msg);
            } else {
                msg = "验证异常 >> " + exception;
                System.out.println(msg);
            }
        }
        model.addAttribute("msg", msg);
        // 此方法不处理登录成功，由shiro进行处理
        return "shiro/login";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", this.message);
        return "shiro/index";
    }

    @RequestMapping("")
    public String home() {
        return "redirect:/index";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logout() {
        Map<String, Object> resuleMap = new LinkedHashMap<String, Object>();
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resuleMap;
    }
}
