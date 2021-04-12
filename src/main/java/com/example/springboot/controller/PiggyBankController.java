package com.example.springboot.controller;

import com.example.springboot.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("piggyBank/")
public class PiggyBankController {
    @Autowired
    public PiggyBankService piggyBankService;

    @RequestMapping("addSpend")
    public Map<String,Object> addSpend(@RequestBody HashMap<String,Object> map){
        int a = piggyBankService.addSpend(map);
        return new HashMap<>();
    }

    @RequestMapping("addIncome")
    public Map<String,Object> addIncome(@RequestBody HashMap<String,Object> map){
        int a = piggyBankService.addIncome(map);
        return new HashMap<>();
    }
}
