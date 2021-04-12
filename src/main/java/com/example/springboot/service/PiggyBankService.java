package com.example.springboot.service;

import java.util.Map;

public interface PiggyBankService {
    public int addSpend(Map<String,Object> map);
    public int addIncome(Map<String,Object> map);
}
