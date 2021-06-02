package com.example.springboot.util;

public class LiftThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
