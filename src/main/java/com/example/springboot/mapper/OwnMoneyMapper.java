package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OwnMoneyMapper {
    public int addSpend(Map<String,Object> map);
    public int addIncome(Map<String,Object> map);
}
