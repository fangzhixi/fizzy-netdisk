package com.fizzy.mapper;

import com.fizzy.pojo.Employee;
import com.fizzy.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> findAll(EmployeeQueryObject employeeQueryObject);

    Integer deleteById(Integer id);

    Integer deleteRoleByEmployeeId(Integer employee_id);

    Integer insertEmployee(Employee employee);

    Integer updateEmployee(Employee employee);

    Employee selectEmployeeById(Integer id);

    Employee selectEmployeeByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<Employee> selectEmployeeByRoleId(@Param("role_id") Integer role_id);
}
