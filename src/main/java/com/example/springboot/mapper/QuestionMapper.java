package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface QuestionMapper {
    Map<String,Object> getQuestionList();
}
