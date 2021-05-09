package com.fizzy.mapper;

import com.fizzy.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {

    List<Permission> findAll();

    Integer insertRolePermission(@Param("role_id") Integer role_id,@Param("permission_id") Integer permission_id);

    Integer deletePermissionByRoleId(Integer role_id);

    Integer deletePermissionById(Integer id);

    Integer deleteAll();

    Integer insertPermission(Permission permission);

    List<Permission> selectPermissionByEmployeeId(Integer employeeId);
}
