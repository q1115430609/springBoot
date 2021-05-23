package com.example.springboot.service;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    List<Map<String,Object>> getQuestionList();
    Map<String,Object> addQuestion(Map<String,Object> map);
}
