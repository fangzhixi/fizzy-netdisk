package com.fizzy.service.impl;

import com.fizzy.mapper.CustomerMapper;
import com.fizzy.query.CustomerQueryObject;
import com.fizzy.service.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceimpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageInfo selectCustomer(CustomerQueryObject customerQueryObject) {
        PageHelper.startPage(customerQueryObject.getCurrentPage(), customerQueryObject.getPageSize());
        return new PageInfo(customerMapper.selectCustomer(customerQueryObject.getStatus(),customerQueryObject.getKeyword(),customerQueryObject.getSellerId()));
    }
}
