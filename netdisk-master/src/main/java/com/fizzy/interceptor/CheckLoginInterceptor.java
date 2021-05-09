package com.fizzy.interceptor;

import com.fizzy.pojo.Employee;
import com.fizzy.service.IEmployeeService;
import com.fizzy.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Employee employee = UserContext.getCurrentUser();
        if (employee == null)
        {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
