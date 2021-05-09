package com.fizzy.controller;

import com.fizzy.pojo.Employee;
import com.fizzy.query.CustomerQueryObject;
import com.fizzy.service.IEmployeeService;
import com.fizzy.service.impl.CustomerServiceimpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceimpl customerService;
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public String list(@ModelAttribute("qo") CustomerQueryObject customerQueryObject,Model model)
    {
        System.out.println("customerQueryObject.getStatus() = " + customerQueryObject.getStatus());
        PageInfo pageInfo = customerService.selectCustomer(customerQueryObject);
        List<Employee> employeeList = employeeService.selectEmployeeByRoleId(12);
        model.addAttribute("qo",customerQueryObject);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("emps",employeeList);
        return "customer/list";
    }

    @RequestMapping("/failList")
    public String faliList(Model model, @ModelAttribute("qo") CustomerQueryObject customerQueryObject)
    {
        customerQueryObject.setStatus(3);//失败客户代号
        PageInfo pageInfo = customerService.selectCustomer(customerQueryObject);
        List<Employee> employeeList = employeeService.selectEmployeeByRoleId(12);
        model.addAttribute("qo",customerQueryObject);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("emps",employeeList);
        return "customerFail/list";
    }
    @RequestMapping("/potentialList")
    public String formalList(Model model, @ModelAttribute("qo") CustomerQueryObject customerQueryObject)
    {
        customerQueryObject.setStatus(0);//潜在客户代号
        PageInfo pageInfo = customerService.selectCustomer(customerQueryObject);
        List<Employee> employeeList = employeeService.selectEmployeeByRoleId(12);
        model.addAttribute("qo",customerQueryObject);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("emps",employeeList);
        return "potentialList/list";
    }
    @RequestMapping("/poolList")
    public String lostList(Model model, @ModelAttribute("qo") CustomerQueryObject customerQueryObject)
    {
        customerQueryObject.setStatus(2);//资源池客户代号
        PageInfo pageInfo = customerService.selectCustomer(customerQueryObject);
        List<Employee> employeeList = employeeService.selectEmployeeByRoleId(12);
        model.addAttribute("qo",customerQueryObject);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("emps",employeeList);
        return "poolList/list";
    }
}
