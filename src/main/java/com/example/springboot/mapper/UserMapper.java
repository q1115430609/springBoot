package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    void loginInMapper(Map<String,Object> params);
    List<User> getUserByUserIdMapper(String userId);
}
