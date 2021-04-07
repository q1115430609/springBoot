package com.example.springboot.service.impl;

import com.example.springboot.mapper.QuestionMapper;
import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    public QuestionMapper questionmapper;

    public List<Map<String,Object>> getQuestionList(){
        List<Map<String,Object>> list = questionmapper.getQuestionList();
        return list;
    }
    public Map<String,Object> addQuestion(Map<String,Object> map){

        questionmapper.addQuestion(map);
        return new HashMap<>();
    }

}
