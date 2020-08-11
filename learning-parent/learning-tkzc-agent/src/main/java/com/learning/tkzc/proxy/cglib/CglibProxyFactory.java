package com.learning.tkzc.proxy.cglib;

import com.learning.tkzc.proxy.UserOperation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * Cglib动态代理工厂
 *
 * @author tangjx
 * @date 2020/8/11 14:00
 */
public class CglibProxyFactory {

    public static UserOperation create(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserOperation.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("cglib代理对象执行前...");
            Object obj = method.invoke(target, objects);
            System.out.println("cglib代理对象执行后...");
            return obj;
        });
        return (UserOperation) enhancer.create();
    }

}
