package com.fizzy.controller;

import com.fizzy.anno.RequiredPermission;
import com.fizzy.pojo.*;
import com.fizzy.pojo.Department;
import com.fizzy.pojo.Employee;
import com.fizzy.pojo.Role;
import com.fizzy.query.EmployeeQueryObject;
import com.fizzy.query.JSONResult;
import com.fizzy.service.IDepartmentService;
import com.fizzy.service.IEmployeeService;
import com.fizzy.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IRoleService roleService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDepartmentService departmentService;

    @RequestMapping("/list")
    @RequiredPermission({"员工列表权限","com.fizzy.controller.EmployeeController.list"})
    public String data(Model model, @ModelAttribute("qo") EmployeeQueryObject employeeQueryObject)
    {
        System.out.println("employeeQueryObject = " + employeeQueryObject);
        PageInfo pageInfo = employeeService.findAll(employeeQueryObject);
        List<Department> depts = departmentService.selectDepartment();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("depts",depts);
        System.out.println("employeeQueryObject = " + employeeQueryObject.getCurrentPage());
        System.out.println("pageInfo = " + pageInfo.getList());
        return "employee/list";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    @RequiredPermission({"员工删除权限","com.fizzy.controller.EmployeeController.delete"})
    public JSONResult delete(@RequestParam("id")Integer id)
    {
        if(employeeService.deleteEmployeeById(id) > 0)
        {
            System.out.println("id = " + id);
            return new JSONResult().success("删除成功!");
        }
        else
            return new JSONResult().noSuccess("没有删除任何数据,请稍后再试");
    }

    @RequestMapping("/input")
    public String input(Integer id,Model model)
    {
        if (id != null)
        {
            Employee employee = employeeService.selectEmployeeById(id);
//            Employee.setId(id);
            System.out.println("Employee = " + employee);
            employee.setRoles(roleService.selectRoleByEmployeeId(id));
            System.out.println("employee = " + employee);
            model.addAttribute("entity", employee);
        }
        List<Role> roleList = roleService.selectRole();
        List<Department> depts = departmentService.selectDepartment();
        model.addAttribute("depts",depts);
        model.addAttribute("roles",roleList);
        return "employee/input";
    }

    @RequestMapping("saveOrUpdate")
    @RequiredPermission({"员工保存与编辑权限","com.fizzy.controller.EmployeeController.saveOrUpdate"})
    public String saveOrUpdate(@ModelAttribute("Employee")Employee employee,@RequestParam(value = "ids",required = false) List<Integer> ids)
    {
        System.out.println("employee = " + employee);
        System.out.println("ids = " + ids);
        employee.setId(employeeService.saveOrUpdate(employee,ids));
        System.out.println("employee = " + employee);
        return "redirect:list";
    }
}
