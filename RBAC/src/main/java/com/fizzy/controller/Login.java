package com.fizzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/emp")
@Controller
public class Login {

    @RequestMapping(value = "/login")
    public String Login(@RequestParam(value = "userId", required = false, defaultValue = "没有信息") String userId,
                        HttpServletRequest request) {
        System.out.println("controller: " + request.getAttribute("userId"));
        return "abcasdf";
    }

}
