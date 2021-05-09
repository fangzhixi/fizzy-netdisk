package com.fizzy.service;

import com.fizzy.pojo.Permission;
import com.fizzy.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IPermissionService {

    PageInfo findAll(QueryObject qo);

    List<Permission> findAllPermission();

    Integer deleteById(Integer id);

    Integer reload();

    List<Permission> selectPermissionByEmployeeId(Integer id);
}
