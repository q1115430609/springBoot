package com.example.springboot.controller;

import com.example.springboot.service.ElectricalLiftService;
import com.example.springboot.util.LiftThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("electricalLift/")
public class ElectricalLift {
    @Autowired
    public ElectricalLiftService electricalLiftService;

    @RequestMapping(value="initLift")
    public String initLift(@RequestBody Map<String,Integer> params){
        int num = params.get("num");
        for(int i=0;i<num;i++) {
            Thread t = new LiftThread();
            t.start();
        }
        return "OK";
    }


}
