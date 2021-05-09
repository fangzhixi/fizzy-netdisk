package com.fizzy.controller;

import com.fizzy.query.JSONResult;
import com.fizzy.query.QueryObject;
import com.fizzy.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/list")
    public String list(@ModelAttribute("qo") QueryObject qo, Model model)
    {
        PageInfo pageInfo = permissionService.findAll(qo);
        model.addAttribute("pageInfo", pageInfo);
        System.out.println("pageInfo = " + pageInfo.getList());
        return "/permission/list";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JSONResult delete(@RequestParam("id")Integer id)
    {
        if(permissionService.deleteById(id) > 0)
        {
            System.out.println("id = " + id);
            return new JSONResult().success("删除成功!");
        }
        else
            return new JSONResult().noSuccess("没有删除任何数据,请稍后再试");
    }

    @RequestMapping("reload")
    public String reload()
    {
        permissionService.reload();
        return "redirect:list";
    }
}
