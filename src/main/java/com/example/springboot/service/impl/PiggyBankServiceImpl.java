package com.example.springboot.service.impl;

import com.example.springboot.service.PiggyBankService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PiggyBankServiceImpl implements PiggyBankService {

    @Override
    public int addSpend(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int addIncome(Map<String, Object> map){
        return 0;
    }
}
