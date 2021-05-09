package com.fizzy.service.impl;

import com.fizzy.mapper.PermissionMapper;
import com.fizzy.mapper.RoleMapper;
import com.fizzy.pojo.Permission;
import com.fizzy.pojo.Role;
import com.fizzy.query.QueryObject;
import com.fizzy.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceimpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public PageInfo findAll(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        PageInfo pageInfo = new PageInfo(roleMapper.findAll());
        return pageInfo;
    }

    public List<Role> selectRole() {
        return roleMapper.findAll();
    }

    public Integer deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    public Role selectRoleById(Integer id) {
            return roleMapper.selectRoleById(id);
    }

    public Integer saveOrUpdate(Role role,List<Integer> ids) {
            if (role.getId() == null || role.getId() == 0)
                roleMapper.insertRole(role);
            permissionMapper.deletePermissionByRoleId(role.getId());
            if(ids != null && ids.size() > 0)
            {
                for(int i=0;i<ids.size();i++)
                    permissionMapper.insertRolePermission(role.getId(),ids.get(i));
                roleMapper.updateRole(role);
            }
            return 1;
    }

    public List<Permission> selectPermissionById(Integer role_id) {
        try {
            if (role_id != null)
                return roleMapper.selectPermissionById(role_id);
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Role> selectRoleByEmployeeId(Integer employeeId) {
        return roleMapper.selectRoleByEmployeeId(employeeId);
    }
}
