package com.example.springboot.controller;

import com.example.springboot.service.PiggyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("piggyBank/")
public class PiggyBankController {
    @Autowired
    public PiggyBankService piggyBankService;

    @RequestMapping("addSpend")
    public Map<String,Object> addSpend(@RequestBody HashMap<String,Object> map){
        piggyBankService.addSpend(map);
        Map<String,Object> map1 = new HashMap<>();
        return map1;
    }

    @RequestMapping("addIncome")
    public Map<String,Object> addIncome(@RequestBody HashMap<String,Object> map){
        piggyBankService.addIncome(map);
        return new HashMap<>();
    }
}
