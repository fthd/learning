package com.learning.tkzc.agent;

import com.learning.tkzc.boot.BootService;
import com.learning.tkzc.buddy.ExchangeClass;
import com.learning.tkzc.buddy.NLog;
import com.learning.tkzc.buddy.NLog4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import java.util.ServiceLoader;

public class JavaAgentTest {


    /**
     * 验证JavaAgent的premain机制
     */
    @Test
    public void test01() {
        System.out.println("正式代码执行中......");
        methodTest();
    }

    private void methodTest() {
        System.out.println("方法测试代码执行中......");
    }


    /**
     * 测试Java SPI机制
     * 该机制用途广泛，数据库驱动也采用该机制实现
     * 好处：无需修改代码就可以实现类的切换
     */
    @Test
    public void test02() {
        ServiceLoader<BootService> serviceLoader = ServiceLoader.load(BootService.class);
        for (BootService bootService : serviceLoader) {
            bootService.print();
        }
    }


    /**
     * Byte Buddy对静态类方法拦截并执行指定方法
     */
    @Test
    public void test03() {
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(ExchangeClass.Log.class)
                .method(ElementMatchers.named("log"))
                .intercept(MethodDelegation.to(ExchangeClass.Log4j.class))
                .make()
                .load(Thread.currentThread().getContextClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        ExchangeClass.Log.log("Log.....");
        ExchangeClass.Log4j.log("Log4j.....");

        ByteBuddyAgent.install();
        new ByteBuddy().redefine(NLog.class)
                .method(ElementMatchers.named("log"))
                .intercept(MethodDelegation.to(NLog4j.class))
                .make()
                .load(Thread.currentThread().getContextClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        NLog.log("NLog.....");
        NLog4j.log("NLog4j.....");
    }

}
