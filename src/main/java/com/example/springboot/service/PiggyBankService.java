package com.example.springboot.service;

import java.util.Map;

public interface PiggyBankService {
    void addSpend(Map<String,Object> map);
    void addIncome(Map<String,Object> map);
}
