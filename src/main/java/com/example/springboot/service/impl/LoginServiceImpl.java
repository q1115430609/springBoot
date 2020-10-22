package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    public UserMapper userMapper;

    public User getUserMassage(String id){
        User user = userMapper.getUser(id);
        return user;
    }
}
