package com.fizzy.mapper;

import com.fizzy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectUser(@Param("phone") String phone, @Param("email") String email);

    Integer insertUser(Map<String, Object> map);

    Integer updateUser(Map<String, Object> map);

    Integer deleteUser(@Param("phone") String phone, @Param("email") String email);
}
