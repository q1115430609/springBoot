package com.example.springboot.service.impl;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.springboot.util.Common.getUuid;
import static com.example.springboot.util.CryptoUtil.decode;
import static com.example.springboot.util.CryptoUtil.encode;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    public UserMapper userMapper;

    public List<User> loginUpService(String userId,String passWord){
        List<User> userList = userMapper.getUserByUserIdMapper(userId);
        if(userList.size() > 0){
            if(userList.get(0).getPassWord().equals(passWord)){
                return userList;
            }
        }
        return null;
    }

    public String loginInService(Map<String,Object> params){

        List<User> listUser = getUserByUserId(params.get("userId").toString());
        if(listUser.size() > 0){
            return "用户名已存在";
        }
        String id = getUuid();
        Date nowTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));
        params.put("id",id);
        params.put("createTime",nowTime);
        params.put("updateTime",nowTime);
        userMapper.loginInMapper(params);
        return "用户创建成功！";
    }

    public List<User> getUserByUserId(String userId){
        List<User> list = userMapper.getUserByUserIdMapper(userId);
        return list;
    }
}
