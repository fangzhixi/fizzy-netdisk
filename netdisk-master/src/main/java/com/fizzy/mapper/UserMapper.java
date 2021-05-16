package com.fizzy.mapper;

import com.fizzy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectUser(@Param("user_id") String userId);

    Integer insertUser(@Param("user_id") String userId,
                       @Param("password") String password,
                       @Param("name") String name,
                       @Param("sex") String sex,
                       @Param("phone") String phone,
                       @Param("email") String email,
                       @Param("user_photo") String userPhoto,
                       @Param("type") String type,
                       @Param("create_date") String createDate,
                       @Param("update_date") String updateDate);

    Integer updateUser(@Param("user_id") String userId,
                       @Param("password") String password,
                       @Param("name") String name,
                       @Param("sex") String sex,
                       @Param("phone") String phone,
                       @Param("email") String email,
                       @Param("user_photo") String userPhoto,
                       @Param("type") String type,
                       @Param("create_date") String createDate,
                       @Param("update_date") String updateDate);

    Integer deleteUser(@Param("update_date") Integer id);
}
