package com.fizzy.service.impl;

import com.fizzy.anno.RequiredPermission;
import com.fizzy.mapper.PermissionMapper;
import com.fizzy.pojo.Permission;
import com.fizzy.query.QueryObject;
import com.fizzy.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public PageInfo findAll(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Permission> PermissionList = permissionMapper.findAll();
        return new PageInfo(PermissionList);
    }

    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.findAll();
    }

    @Override
    public Integer deleteById(Integer id) {
        return permissionMapper.deletePermissionById(id);
    }

    @Override
    public Integer reload()
    {
        permissionMapper.deleteAll();//删除表里所有字段

        Map<String,Object> beansWithAnnotation = ctx.getBeansWithAnnotation(Controller.class);
        Collection<Object> controllers = beansWithAnnotation.values();
        for (Object controller : controllers) {
            System.out.println("controller = " + controller);
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequiredPermission.class)) {
                    RequiredPermission annotation = method.getAnnotation(RequiredPermission.class);
                    String[] strings = annotation.value();
                    Permission permission = new Permission();
                    permission.setName(strings[0]);
                    permission.setExpression(strings[1]);
                    System.out.println("strings[0] = " + strings[0]);
                    System.out.println("strings[1] = " + strings[1]);
                    permissionMapper.insertPermission(permission);
                }
            }

        }
        return  1;
    }

    @Override
    public List<Permission> selectPermissionByEmployeeId(Integer employeeId) {
        return permissionMapper.selectPermissionByEmployeeId(employeeId);
    }
}
