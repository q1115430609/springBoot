package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.List;
import java.util.Map;

public interface LoginService {
    List<User> loginUpService(String userId,String passWord);
    String loginInService(Map<String,Object> params);
}
