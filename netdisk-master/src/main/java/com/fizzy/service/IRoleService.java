package com.fizzy.service;

import com.fizzy.pojo.Permission;
import com.fizzy.pojo.Role;
import com.fizzy.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {

    PageInfo findAll(QueryObject qo);

    List<Role> selectRole();

    Role selectRoleById(Integer id);

    Integer deleteById(Integer id);

    Integer saveOrUpdate(Role role,List<Integer> ids);

    List<Permission> selectPermissionById(Integer role_id);

    List<Role> selectRoleByEmployeeId(Integer employeeId);
}
