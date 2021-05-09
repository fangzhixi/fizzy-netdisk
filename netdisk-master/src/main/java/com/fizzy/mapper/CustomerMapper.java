package com.fizzy.mapper;

import com.fizzy.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    List<Customer> selectCustomer(@Param("status") Integer status, @Param("keyword") String keyword, @Param("sellerId") Integer sellerId);
}
