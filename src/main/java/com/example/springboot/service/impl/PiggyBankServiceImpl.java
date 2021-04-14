package com.example.springboot.service.impl;

import com.example.springboot.mapper.PiggyBankMapper;
import com.example.springboot.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PiggyBankServiceImpl implements PiggyBankService {

    @Autowired
    PiggyBankMapper piggyBankMapper;

    @Override
    public int addSpend(Map<String, Object> map) {
        int a = piggyBankMapper.addSpend(map);
        return 0;
    }

    @Override
    public int addIncome(Map<String, Object> map){
        int a = piggyBankMapper.addIncome(map);
        return 0;
    }
}
