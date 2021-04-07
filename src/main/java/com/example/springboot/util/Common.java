package com.example.springboot.util;

import java.util.UUID;

public class Common {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","").toLowerCase();
    }
}
