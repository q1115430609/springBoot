package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("question/")
public class QuestionController {
    @Autowired
    public QuestionService questionService;

    @RequestMapping("getQuestionList")
    public List<Map<String,Object>> getQuestionList(@RequestBody HashMap<String,Object> map){
        List<Map<String,Object>> list = questionService.getQuestionList();

        return list;
    }

    @RequestMapping("addQuestion")
    public Map<String,Object> addQuestion(@RequestBody HashMap<String,Object> map){
        Map<String,Object> map1 = questionService.addQuestion(map);
        return map1;
    }

}
