package com.fizzy.mapper;

import com.fizzy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectUser(@Param("user_id") String userId);

    Integer insertUser(Map<String,Object> map);

    Integer updateUser(Map<String,Object> map);

    Integer deleteUser(@Param("user_id") String user_id);
}
