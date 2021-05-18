package com.fizzy.service.impl;

import com.fizzy.mapper.UserMapper;
import com.fizzy.pojo.User;
import com.fizzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUser(String phone, String email) {
        return userMapper.selectUser(phone, email);
    }

    @Override
    public Integer insertUser(String phone, String email, String password, String name, Integer sex, String userPhoto, Integer type, Date createTime, Date updateTime) {
        User user = new User().buildPhone(phone)
                .buildEmail(email)
                .buildPassword(password)
                .buildName(name)
                .buildSex(sex)
                .buildUserPhoto(userPhoto)
                .buildType(type)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return userMapper.insertUser(user.getMap());
    }

    @Override
    public Integer updateUser(String phone, String email, String password, String name, Integer sex, String userPhoto, Integer type, Date createTime, Date updateTime) {
        User user = new User().buildPhone(phone)
                .buildEmail(email)
                .buildPassword(password)
                .buildName(name)
                .buildSex(sex)
                .buildUserPhoto(userPhoto)
                .buildType(type)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return userMapper.updateUser(user.getMap());
    }

    @Override
    public Integer deleteUser(String phone, String email) {
        return userMapper.deleteUser(phone, email);
    }
}
