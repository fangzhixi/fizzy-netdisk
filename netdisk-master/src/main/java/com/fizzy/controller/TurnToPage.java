package com.fizzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurnToPage {

    @RequestMapping("/register")
    public String TurnToRegisterPage(){
        return "register.jsp";
    }
}
