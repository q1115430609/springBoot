package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("test/")
public class LoginController {

    @Autowired
    public LoginService loginService;

    @RequestMapping("login")
    public String login(@RequestBody HashMap<String,Object> map){
        String id = String.valueOf(map.get("id"));
        User user = loginService.getUserMassage(id);
        System.out.println("user");
        return user.getRealName();
    }

    @RequestMapping("testGetMethod")
    public String testGetMethod(HashMap<String,Object> map){
        return "Hello World";
    }
}
