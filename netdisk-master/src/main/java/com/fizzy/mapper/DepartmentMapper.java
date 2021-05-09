package com.fizzy.mapper;

import com.fizzy.pojo.Department;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DepartmentMapper {

    List<Department> findAll();

    Department selectDepartmentById(Integer id);

    Integer deleteById(@RequestParam("id")Integer id);

    Integer insertDepartment(Department department);

    Integer updateDepartment(Department department);
}
