package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("question/")
public class QuestionController {
    @Autowired
    public QuestionService questionService;

    @RequestMapping("getQuestionList")
    public Map<String,Object> getQuestionList(@RequestBody HashMap<String,Object> map){
        Map<String,Object> mapa = questionService.getQuestionList();

        return mapa;
    }
}
