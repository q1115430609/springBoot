package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AnswerMapper {
    void addAnswer(List<Map<String,Object>> list);
    List<Map<String,Object>> getAnswerList(String questionId);
}
