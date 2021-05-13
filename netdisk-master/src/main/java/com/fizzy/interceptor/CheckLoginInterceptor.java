package com.fizzy.interceptor;

import com.fizzy.util.sdk.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //Header token 范例  Access-Token: v2fHgKa784YJE3SKVkv44lBoJisMxmdk1154752643
        Token token = new Token(request.getAttribute("Access-Token").toString());
        System.out.println("Access-Token:  "+ request.getHeader("Access-Token"));
        System.out.println("Host:  "+ request.getHeader("Host"));
        if (token.tokenInvoice()){
            System.out.println("放行");
            request.setAttribute("userId",request.getHeader("Host"));
            return true;
        }else {
            System.out.println("CheckLoginInterceptor不放行");
            response.sendRedirect("/");
            return false;
        }
    }
}
