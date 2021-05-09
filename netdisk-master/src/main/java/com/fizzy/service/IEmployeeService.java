package com.fizzy.service;

import com.fizzy.pojo.Employee;
import com.fizzy.query.EmployeeQueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IEmployeeService {
    Integer saveOrUpdate(Employee employee, List<Integer> ids);

    Employee selectEmployeeById(Integer id);

    PageInfo findAll(EmployeeQueryObject employeeQueryObject);

    Integer deleteEmployeeById(Integer id);

    Employee selectEmployeeByUsernameAndPassword(String username, String password);

    List<Employee> selectEmployeeByRoleId(Integer roleId);
}
