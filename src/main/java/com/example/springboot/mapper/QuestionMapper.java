package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionMapper {
    List<Map<String,Object>> getQuestionList();
    void addQuestion(Map<String,Object> map);
}
