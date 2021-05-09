package com.fizzy.controller;

import com.fizzy.anno.RequiredPermission;
import com.fizzy.pojo.Department;
import com.fizzy.query.JSONResult;
import com.fizzy.query.QueryObject;
import com.fizzy.service.impl.DepartmentServiceimpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceimpl departmentService;


    @RequestMapping("/list")
    @RequiredPermission({"部门列表权限","com.fizzy.controller.DepartmentController.list"})
    public String data(Model model, @ModelAttribute("qo")QueryObject queryObject)
    {
        System.out.println("queryObject = " + queryObject);
        PageInfo pageInfo = departmentService.findAll(queryObject);
        model.addAttribute("pageInfo",pageInfo);
        return "department/list";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    @RequiredPermission({"部门删除权限","com.fizzy.controller.DepartmentController.delete"})
    public JSONResult delete(@RequestParam("id")Integer id)
    {
        System.out.println("123321");
        if(departmentService.deleteById(id) > 0)
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
            Department department = departmentService.selectDepartmentById(id);
            department.setId(id);
            model.addAttribute("entity", department);
        }
        return "department/input";
    }

    @RequestMapping("saveOrUpdate")
    @RequiredPermission({"部门保存与编辑权限","com.fizzy.controller.DepartmentController.saveOrUpdate"})
    public String saveOrUpdate(Model model,@ModelAttribute("department")Department department)
    {
        System.out.println("department = " + department);
        department.setId(departmentService.saveOrUpdate(department));
        System.out.println("department = " + department);
        return "redirect:list";
    }
}
