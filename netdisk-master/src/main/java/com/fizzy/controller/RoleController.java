package com.fizzy.controller;

import com.fizzy.anno.RequiredPermission;
import com.fizzy.query.JSONResult;
import com.fizzy.pojo.Permission;
import com.fizzy.pojo.Role;
import com.fizzy.query.QueryObject;
import com.fizzy.service.IPermissionService;
import com.fizzy.service.impl.RoleServiceimpl;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceimpl roleService;
    @Autowired
    IPermissionService permissionService;

    @RequestMapping("/list")
    @RequiredPermission({"角色列表权限","com.fizzy.controller.RoleController.list"})
    public String list(@ModelAttribute("qo")QueryObject qo, Model model)
    {
        PageInfo pageInfo = roleService.findAll(qo);
        model.addAttribute("pageInfo", pageInfo);
        return "/role/list";
    }

    @RequestMapping(value = "/delete")
    @RequiredPermission({"角色删除权限","com.fizzy.controller.RoleController.delete"})
    @ResponseBody
    public JSONResult delete(@RequestParam("id")Integer id)
    {
        System.out.println("123321");
        if(roleService.deleteById(id) > 0)
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
            Role role = roleService.selectRoleById(id);
            role.setId(id);
            role.setPermissionList(roleService.selectPermissionById(id));
            System.out.println("role = " + role);
            model.addAttribute("role", role);
        }
        List<Permission> permissionList = permissionService.findAllPermission();
        model.addAttribute("permissions",permissionList);
        return "/role/input";

    }

    @RequestMapping("saveOrUpdate")
    @RequiredPermission({"角色保存与编辑权限","com.fizzy.controller.RoleController.saveOrUpdate"})
    public String saveOrUpdate(@ModelAttribute("Role")Role role,@RequestParam(value = "ids",required = false) List<Integer> ids)
    {
        role.setId(roleService.saveOrUpdate(role,ids));
        return "redirect:list";
    }
}
