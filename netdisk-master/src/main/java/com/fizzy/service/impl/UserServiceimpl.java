package com.fizzy.service.impl;

import com.fizzy.mapper.UserMapper;
import com.fizzy.pojo.User;
import com.fizzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceimpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUser(Map<String, Object> map) {
        return userMapper.selectUser(map);
    }
}
