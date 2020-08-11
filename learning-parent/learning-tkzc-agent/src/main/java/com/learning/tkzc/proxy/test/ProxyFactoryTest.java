package com.learning.tkzc.proxy.test;

import com.learning.tkzc.proxy.UserOperation;
import com.learning.tkzc.proxy.cglib.CglibProxyFactory;
import com.learning.tkzc.proxy.impl.UserOperationImpl;
import com.learning.tkzc.proxy.jdk.JdkProxyFactory;

/**
 * JDK动态代理验证
 *
 * @author tangjx
 * @date 2020/8/11 13:47
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {
        UserOperation userOperation = new UserOperationImpl();
        UserOperation proxyUserOperation = JdkProxyFactory.create(userOperation);
        System.out.println("***************JDK代理用户添加***************");
        proxyUserOperation.userAdd();
        System.out.println("***************JDK代理用户删除***************");
        proxyUserOperation.userDel();

        UserOperation userOperation2 = new UserOperationImpl();
        UserOperation proxyUserOperation2 = CglibProxyFactory.create(userOperation2);
        System.out.println("***************CGLIB代理用户添加***************");
        proxyUserOperation2.userAdd();
        System.out.println("***************CGLIB代理用户删除***************");
        proxyUserOperation2.userDel();

    }

}
