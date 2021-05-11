package com.fizzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    //注册请求
    @ResponseBody
    @RequestMapping(value = "/sign-up", produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public String Register(@RequestParam(value = "user_id", required = true)String userId,
                        @RequestParam(value = "password", required = true)String password){
        System.out.printf("收到用户注册请求 => user_id:%s password:%s\n",userId,password);
        return "{\"message\":\"" + userId + "\"}";
    }

    //登录请求
    @ResponseBody
    @RequestMapping(value = "/sign-in", produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public String Login(@RequestParam(value = "user_id", required = true)String userId,
            @RequestParam(value = "password", required = true)String password){
        System.out.printf("收到用户登录请求 => user_id:%s password:%s\n",userId,password);
        return "{\"message\":\"" + userId + "\"}";
    }

}
