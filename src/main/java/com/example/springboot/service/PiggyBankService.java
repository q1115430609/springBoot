package com.example.springboot.service;

import java.util.Map;

public interface PiggyBankService {
    public void addSpend(Map<String,Object> map);
    public void addIncome(Map<String,Object> map);
}
