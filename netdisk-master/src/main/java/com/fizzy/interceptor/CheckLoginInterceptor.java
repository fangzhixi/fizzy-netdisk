package com.fizzy.interceptor;

import com.fizzy.pojo.User;
import com.fizzy.util.sdk.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        Object Attribute = request.getParameter("token");
        if (Attribute == null){
            System.out.println("CheckLoginInterceptor不放行(token为空)");
            response.sendRedirect("/");
            return false;
        }
        System.out.println("login token: " + Attribute.toString());

        //Header token 范例  Access-Token: v2fHgKa784YJE3SKVkv44lBoJisMxmdk1154752643
        Token token = new Token(Attribute.toString());
        System.out.println("token:  " + Attribute);
        System.out.println("Host:  " + request.getHeader("Host"));
        if (token.tokenInvoice()) {
            System.out.println("放行");

            request.setAttribute("user_id", token.getUserId());
            return true;
        } else {
            System.out.println("CheckLoginInterceptor不放行(token校验不通过)");
            response.sendRedirect("/");
            return false;
        }
    }
}
