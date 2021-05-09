package com.fizzy.service;

import com.fizzy.pojo.Department;
import com.fizzy.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IDepartmentService {

    PageInfo findAll(QueryObject queryObject);

    Integer deleteById(Integer id);

    Integer saveOrUpdate(Department department);

    List<Department> selectDepartment();
}
