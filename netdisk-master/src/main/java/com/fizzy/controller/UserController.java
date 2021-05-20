package com.fizzy.controller;

import com.fizzy.pojo.User;
import com.fizzy.service.IUserService;
import com.fizzy.util.sdk.Token;
import com.fizzy.util.sdk.regular.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    //登录请求
    @RequestMapping(value = "/sign-in")
    public String AmainPage(@CookieValue(value = "account", required = true) String account,//账号
                            @CookieValue(value = "password", required = true) String password,//密码
                            HttpServletRequest request,
                            Model model) {
        String phone = Verification.isPhone(account) ? account : "";
        String email = Verification.isEmail(account) ? account : "";

        User user = null;
        List<User> userList = userService.selectUser(phone, email);
        user = userList.size() > 0 ? userList.get(0) : null;

        if (user != null && user.getPassword().equals(password)) {
            //业务处理
            Token token = new Token("RSA-SHA256", user.getUserId(), (int) (Math.random() * 1000000), Calendar.getInstance().getTimeInMillis(), Token.getMasterKey());
            String signature = token.rsaEncryptOutBase64(token.format());
            System.out.println("token:  " + signature);

            model.addAttribute("token", "token = '" + signature + "';");
            model.addAttribute("pass", "pass = true;");

            return "../../login.jsp";
        } else {
            model.addAttribute("account", "account = '" + account + "';");
            model.addAttribute("notPass", "notPass = true;");
            System.out.println("后台登陆账号或密码错误");
            System.out.println("account" + account);
            System.out.println("password" + password);
            return "../../login.jsp";
        }
    }

    //注册请求
    @ResponseBody
    @RequestMapping(value = "/sign-up", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public String Register(@RequestParam(value = "phone", required = false, defaultValue = "") String phone,
                           @RequestParam(value = "email", required = false, defaultValue = "") String email,
                           @RequestParam(value = "password", required = true) String password) {
        System.out.printf("收到用户注册请求 => phone: %s email: %s password: %s\n", phone, email, password);
        return "{\"message\":\"" + phone + "\"}";
    }
}
