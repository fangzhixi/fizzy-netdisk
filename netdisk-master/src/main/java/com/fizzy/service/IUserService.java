package com.fizzy.service;

import com.fizzy.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface IUserService {

    List<User> selectUser(String phone, String email);

    Integer insertUser(String phone, String email, String password, String name, Integer sex, String userPhoto, Integer type, Date createTime, Date updateTime);

    Integer updateUser(String phone, String email, String password, String name, Integer sex, String userPhoto, Integer type, Date createTime, Date updateTime);

    Integer deleteUser(String phone, String email);
}
