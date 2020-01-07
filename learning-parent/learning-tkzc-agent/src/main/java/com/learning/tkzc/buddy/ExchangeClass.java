package com.learning.tkzc.buddy;

public class ExchangeClass {

    public static class Log {
        public static void log(String a) {
            System.out.println("Log: " + a);
        }
    }

    public static class Log4j {
        public static void log(String a) {
            System.err.println("Log4j: " + a);
        }
    }

}
