package com.fizzy.service;

import com.fizzy.query.CustomerQueryObject;
import com.github.pagehelper.PageInfo;

public interface ICustomerService {


    PageInfo selectCustomer(CustomerQueryObject customerQueryObject);
}
