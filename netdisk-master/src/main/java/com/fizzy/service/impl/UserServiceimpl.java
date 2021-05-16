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
    public List<User> selectUser(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public Integer insertUser() {
        return userMapper.insertUser(map);
    }

    @Override
    public Integer updateUser(String userId) {
        return userMapper.updateUser();
    }

    @Override
    public Integer deleteUser(String userId) {
        return userMapper.deleteUser();
    }
}
