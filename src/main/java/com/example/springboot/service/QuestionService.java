package com.example.springboot.service;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    public List<Map<String,Object>> getQuestionList();
    public Map<String,Object> addQuestion(Map<String,Object> map);
}
