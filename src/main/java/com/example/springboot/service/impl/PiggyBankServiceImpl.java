package com.example.springboot.service.impl;

import com.example.springboot.mapper.OwnMoneyMapper;
import com.example.springboot.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PiggyBankServiceImpl implements PiggyBankService {

    @Autowired
    OwnMoneyMapper ownMoneyMapper;

    @Override
    public void addSpend(Map<String, Object> map) {
        int a = ownMoneyMapper.addSpend(map);
    }

    @Override
    public void addIncome(Map<String, Object> map){
        int a = ownMoneyMapper.addIncome(map);
    }
}
