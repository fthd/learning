package com.learning.tkzc.agent.test;

import java.lang.instrument.Instrumentation;

public class JavaAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation)  {
        System.out.println("JavaAgent一点不萌执行中......");
    }

}
