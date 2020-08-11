package com.learning.tkzc.proxy.jdk;

import com.learning.tkzc.proxy.UserOperation;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 基于接口的动态代理实现
 *
 * @author tangjx
 * @date 2020/8/11 10:18
 */
public class JdkProxyFactory {


    public static UserOperation create(Object target) {
        return (UserOperation) Proxy.newProxyInstance(JdkProxyFactory.class.getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("JDK动态代理执行方法之前...");
            Object obj = method.invoke(target, args);
            System.out.println("JDK动态代理执行方法之后...");
            return obj;
        });
    }

}
