package com.fizzy.service.impl;

import com.fizzy.exception.MyException;
import com.fizzy.mapper.EmployeeMapper;
import com.fizzy.mapper.RoleMapper;
import com.fizzy.pojo.Employee;
import com.fizzy.query.EmployeeQueryObject;
import com.fizzy.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class EmployeeServiceimpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoleMapper roleMapper;

    public PageInfo findAll(EmployeeQueryObject employeeQueryObject) {
        PageHelper.startPage(employeeQueryObject.getCurrentPage(), employeeQueryObject.getPageSize());
        PageInfo pageInfo = new PageInfo(employeeMapper.findAll(employeeQueryObject));
        System.out.println("pageInfo = " + pageInfo.getList());
        return pageInfo;
    }

    public Integer deleteEmployeeById(Integer id) {
        roleMapper.deleteRoleByEmployeeId(id);
        Integer cout = employeeMapper.deleteById(id);
        if (cout > 0)
            return cout;
        else
            throw new MyException("删除用户数据失败");
    }

    @Override
    public Employee selectEmployeeByUsernameAndPassword(String username, String password) {
        return employeeMapper.selectEmployeeByUsernameAndPassword(username,password);
    }

    @Override
    public List<Employee> selectEmployeeByRoleId(Integer roleId) {
        return employeeMapper.selectEmployeeByRoleId(roleId);
    }

    public Integer saveOrUpdate(Employee employee, List<Integer> ids) {
            if (employee.getId() == null || employee.getId() == 0)
            {
                if (employeeMapper.insertEmployee(employee) > 0)
                    throw new MyException("插入用户数据失败");
            }
            else
                if (employeeMapper.updateEmployee(employee) > 0)
                    throw new MyException("更新用户数据失败");
            roleMapper.deleteRoleByEmployeeId(employee.getId());
            if(ids!=null && ids.size() > 0)
            {
                for(int i=0;i<ids.size();i++)
                    roleMapper.insertRoleByEmployeeId(employee.getId(),ids.get(i));
            }
            return 1;
    }

    public Employee selectEmployeeById(Integer id) {
        return employeeMapper.selectEmployeeById(id);
    }


}
