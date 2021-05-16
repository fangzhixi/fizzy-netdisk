package com.fizzy.service;

import com.fizzy.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    List<User> selectUser(String userId);

    Integer insertUser(String userId);

    Integer updateUser(String userId);

    Integer deleteUser(String userId);
}
