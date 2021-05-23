package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("login/")
public class LoginController {

    @Autowired
    public LoginService loginService;

    @RequestMapping("testGetMethod")
    public String testGetMethod(HashMap<String,Object> map){
        return "Hello World";
    }

    @RequestMapping("loginUp")
    public User loginUp(@RequestBody HashMap<String,Object> params){
        String userId = String.valueOf(params.get("userId"));
        String passWord = String.valueOf(params.get("passWord"));
        List<User> list = loginService.loginUpService(userId, passWord);

        return list != null ? list.get(0) : null;
    }

    @RequestMapping("loginIn")
    public Map<String,String> String(@RequestBody HashMap<String,Object> params){
        Map<String,String> reMap = new HashMap<>();
        String result = loginService.loginInService(params);
        reMap.put("data",result);
        return reMap;
    }

}
