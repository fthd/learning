package com.learning.tkzc.boot;

public class MysqlBootService implements  BootService {
    @Override
    public void print() {
        System.out.println("Mysql驱动服务启动...");
    }
}
