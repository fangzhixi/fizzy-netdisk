package com.fizzy.controller;

import com.fizzy.pojo.Employee;
import com.fizzy.pojo.Permission;
import com.fizzy.query.JSONResult;
import com.fizzy.service.IEmployeeService;
import com.fizzy.service.IPermissionService;
import com.fizzy.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(@RequestParam("username")String username,@RequestParam("password")String password)
    {
        Employee employee = employeeService.selectEmployeeByUsernameAndPassword(username,password);
        System.out.println("employee = " + employee);
        if (employee != null)
        {
            List<Permission> permissions = permissionService.selectPermissionByEmployeeId(employee.getId());
            UserContext.setCurrentUser(employee);
            UserContext.setCurrentEmpPermission(permissions);
            return new JSONResult().success(null);
        }
        else
            return  new JSONResult().noSuccess("登录失败");
    }
}
