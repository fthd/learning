package com.learning.tkzc.thread;

public class ThreadLocalTest extends Thread {

    private ThreadLocal<String> threadLocalTest= new ThreadLocal<>();

    @Override
    public void run() {
        System.out.println("2="+threadLocalTest.get());
    }

    public void test01() {
        threadLocalTest.set("aaaaaaaaaaaaaa");
        System.out.println("1="+threadLocalTest.get());
        new ThreadLocalTest().start();
        System.out.println("3="+threadLocalTest.get());
    }

    public static void main(String[] args) {
        new ThreadLocalTest().test01();
    }


}
