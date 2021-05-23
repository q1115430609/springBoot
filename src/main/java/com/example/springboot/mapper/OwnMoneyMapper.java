package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OwnMoneyMapper {
    int addSpend(Map<String,Object> map);
    int addIncome(Map<String,Object> map);
}
