package com.fizzy.service.impl;

import com.fizzy.exception.MyException;
import com.fizzy.mapper.DepartmentMapper;
import com.fizzy.pojo.Department;
import com.fizzy.query.QueryObject;
import com.fizzy.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimpl implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    public PageInfo findAll(QueryObject queryObject)
    {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        PageInfo pageInfo = new PageInfo(departmentMapper.findAll());
        return pageInfo;
    }

    public Department selectDepartmentById(Integer id)
    {
        return departmentMapper.selectDepartmentById(id);
    }

    public Integer deleteById(Integer id) {
        Integer cout = departmentMapper.deleteById(id);
        if (cout > 0)
            return cout;
        else
        {
            throw new MyException("删除不了部门");
        }
    }

    public Integer saveOrUpdate(Department department) {
        Integer insertCout = -1;
        Integer updateCout = -1;
        if (department.getId() == null || department.getId() == 0)
            insertCout = departmentMapper.insertDepartment(department);
        else
            updateCout = departmentMapper.updateDepartment(department);
        if(insertCout > 0 || updateCout > 0)
            return insertCout >= updateCout ? insertCout : updateCout;
        throw new MyException(insertCout != -1 ? "插入数据失败" : "更新数据失败");
    }

    @Override
    public List<Department> selectDepartment() {
        return departmentMapper.findAll();
    }
}
