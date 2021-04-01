package com.example.springboot.service.impl;

import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired

    public Map<String,Object> getQuestionList(){
        return new HashMap<>();
    }
}
