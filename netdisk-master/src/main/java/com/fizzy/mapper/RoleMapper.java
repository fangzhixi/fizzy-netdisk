package com.fizzy.mapper;

import com.fizzy.pojo.Permission;
import com.fizzy.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    List<Permission> selectPermissionById(Integer role_id);

    Role selectRoleById(Integer id);

    Integer deleteById(@RequestParam("id")Integer id);

    Integer insertRole(Role role);

    Integer updateRole(Role role);

    List<Role> selectRoleByEmployeeId(Integer employeeId);

    Integer deleteRoleByEmployeeId(@Param("employee_id")Integer employee_id);

    Integer insertRoleByEmployeeId(@Param("employee_id") Integer employee_id, @Param("role_id") Integer role_id);
}
