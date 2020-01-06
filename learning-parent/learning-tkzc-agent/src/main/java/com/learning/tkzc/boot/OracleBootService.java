package com.learning.tkzc.boot;

public class OracleBootService implements BootService {
    @Override
    public void print() {
        System.out.println("Oracle驱动服务启动...");
    }
}
