package com.fizzy.service;

import com.fizzy.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> selectUser(Map<String, Object> map);
}
