package com.fizzy.controller;

import com.fizzy.pojo.User;
import com.fizzy.service.IUserService;
import com.fizzy.util.sdk.RSAEncryption;
import com.fizzy.util.sdk.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    //注册请求
    @ResponseBody
    @RequestMapping(value = "/sign-up", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public String Register(@RequestParam(value = "user_id", required = true) String userId,
                           @RequestParam(value = "password", required = true) String password) {
        System.out.printf("收到用户注册请求 => User_id:%s password:%s\n", userId, password);
        return "{\"message\":\"" + userId + "\"}";
    }

    //登录请求
    @RequestMapping(value = "/sign-in")
    public String AmainPage(@CookieValue(value = "user_id", required = true) String userId,
                            @CookieValue(value = "password", required = true) String password,
                            Model model) {
        User user = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userId);
        List<User> userList = userService.selectUser(userId);
        if (userList.size() > 0)
            user = userList.get(0);
        if (user != null && user.getPassword().equals(password)) {
            //业务处理
            Token token = new Token("RSA-SHA256", userId, (int) (Math.random() * 1000000), Calendar.getInstance().getTimeInMillis(), Token.getMasterKey());
            String signature = token.rsaEncryptOutBase64(token.format());
            System.out.println("Access-Token:  "+ signature);
            model.addAttribute("token", signature);
            return "main.jsp";
        } else {
            model.addAttribute("user_id", "user_id = '" + userId + "';");
            model.addAttribute("notPass", "notPass = true;");
            System.out.println("后台登陆账号或密码错误");
            System.out.println("userId" + userId);
            System.out.println("password" + password);
            return "../../login.jsp";
        }
    }

}
