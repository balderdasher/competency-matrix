package com.mrdios.competencymatrix.springboot.example.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxiong
 * @date 2016-11-29 17:23
 */
@Controller
@RequestMapping("/test")
public class MyController {

    @Value("${info.app_name}")
    private String message;

    @RequestMapping("/html")
    public String test(Model model) {
        model.addAttribute("time",new Date());
        model.addAttribute("message",this.message);
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Map<String, Object> testJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        return map;
    }
}
